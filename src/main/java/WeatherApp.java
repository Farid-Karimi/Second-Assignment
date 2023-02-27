import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

import static java.lang.Integer.*;

public class WeatherApp {
    public final static String apiKey = "2a5bd33aafef44c680b141355232502";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter City name: ");
        String CityName = input.nextLine();
        String weatherData = getWeatherData(CityName);
//        double temperature = getTemperature(weatherData);
        int Humidity = getHumidity(weatherData);
        //------------------------------
        JFrame frame = new JFrame("Weather");
        frame.setSize(450, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("icon.png");
        ImageIcon wall = new ImageIcon("wall.png");
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(193,219,234));

        String humidity = "Humidity : " + getHumidity(weatherData);
        String temperature = "temperature : " + getTemperature(weatherData);
        String region = "region : " + getRegion(weatherData);
        String WindKph = "Wind Kph : " + getWind(weatherData);
        String Condition = "Sky Condition : " + getCondition(weatherData);

        JLabel labelRegion = new JLabel(region);
        labelRegion.setBounds(50, 50, 400, 30);
        labelRegion.setForeground(new Color(27,156,227));
        labelRegion.setFont(new Font("Bahnschrift" , Font.PLAIN ,20));

        JLabel labelWindKph = new JLabel(WindKph);
        labelWindKph.setBounds(50, 250, 300, 30);
        labelWindKph.setForeground(new Color(27,156,227));
        labelWindKph.setFont(new Font("Bahnschrift" , Font.PLAIN ,20));

        JLabel labelHumidity = new JLabel(humidity);
        labelHumidity.setBounds(50, 100, 300, 30);
        labelHumidity.setForeground(new Color(27,156,227));
        labelHumidity.setFont(new Font("Bahnschrift" , Font.PLAIN ,20));

        JLabel labelTemperature = new JLabel(temperature);
        labelTemperature.setBounds(50, 150, 300, 30);
        labelTemperature.setForeground(new Color(27,156,227));
        labelTemperature.setFont(new Font("Bahnschrift" , Font.PLAIN ,20));

        JLabel labelCondition = new JLabel(Condition);
        labelCondition.setBounds(50, 200, 300, 30);
        labelCondition.setForeground(new Color(27,156,227));
        labelCondition.setFont(new Font("Bahnschrift" , Font.PLAIN ,20));

        panel.add(labelWindKph);
        panel.add(labelHumidity);
        panel.add(labelTemperature);
        panel.add(labelCondition);
        panel.add(labelRegion);

        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Retrieves weather data for the specified city.
     *
     * @param city the name of the city for which weather data should be retrieved
     * @return a string representation of the weather data, or null if an error occurred
     */
    public static String getWeatherData(String city) {
        try {
            URL url = new URL("http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static double getTemperature(String weatherJson){
        double answer = 0.0;
        JSONObject weatherMan = new JSONObject(weatherJson);
        answer = weatherMan.getJSONObject("current").getDouble("temp_c");
        return answer;
    }
    public static String getCondition(String weatherJson){
        String answer;
        JSONObject weatherMan = new JSONObject(weatherJson);
        answer = weatherMan.getJSONObject("current").getJSONObject("condition").getString("text");
        return answer;
    }
    public static String getRegion(String weatherJson){
        String answer;
        JSONObject weatherMan = new JSONObject(weatherJson);
        answer = weatherMan.getJSONObject("location").getString("region");
        return answer;
    }
    public static double getWind(String weatherJson){
        double answer = 0.0;
        JSONObject weatherMan = new JSONObject(weatherJson);
        answer = weatherMan.getJSONObject("current").getDouble("wind_kph");
        return answer;
    }
    public static int getHumidity(String weatherJson){
        int answer = 0;
        JSONObject weatherMan = new JSONObject(weatherJson);
        answer = (weatherMan.getJSONObject("current").getInt("humidity"));
        return answer;
    }
}
