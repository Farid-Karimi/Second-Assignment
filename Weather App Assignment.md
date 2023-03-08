# Weather App Assignment



## Introduction  
In this assignment, I have built a simple Java application that connects to a weather API and retrieves information about the current weather conditions of a given city.  

## Git & GitHub
first I downloaded git from [Git-SCM](https://git-scm.com/download/win) then I configured my name and email address using these commands:
>git config --global user. name
>git config --global user. email

and initialized git in my homework folder and forked the `Second Assignment` repo to my **GitHub** and then to my local device.
Ialso initialized a second branch named `Develop` and did all my temporary changes there so I can merge it with the master branch later when I'm assured everything is done.

### SSH  for  GitHub
To clone a GitHub repo I had to setup my **SSH** key I did this by getting some help from both my mentor and my friend and using a [tutorial in internet](https://medium.com/devops-with-valentine/2021-how-to-set-up-your-ssh-key-for-github-on-windows-10-afe6e729a3c0)



## resources
- [To inspect the data from the weatherAPI site](https://www.weatherapi.com/api-explorer.aspx)  
- [To learn Mark Down](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)
- [To learn about GUI and Swing](https://www.youtube.com/watch?v=Kmgo00avvEw&list=WL&index=1)
- [To learn more about Json](https://www.youtube.com/watch?v=iiADhChRriM&t=571s)
- [Json syntax](https://processing.org/reference/JSONObject.html)



## Tasks  

I got an API key from https://www.weatherapi.com/. by signing up and verifying my email.  

copied the **API** key and stored it in the String variable named `apiKey`.  

Added the [org.json](https://mvnrepository.com/artifact/org.json/json) package to Gradle in the dependencies.       

```java
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
    // https://mvnrepository.com/artifact/org.json/json
    implementation group: 'org.json', name: 'json', version: '20220924'

}
```

coded the functions to get the humidity and temperature and other functions that I added my self using **JSON**. 

```java
public static int getHumidity(String weatherJson){
        int answer = 0;
        JSONObject weatherMan = new JSONObject(weatherJson);
        answer = (weatherMan.getJSONObject("current").getInt("humidity"));
        return answer;
}
public static double getWind(String weatherJson){
        double answer = 0.0;
        JSONObject weatherMan = new JSONObject(weatherJson);
        answer = weatherMan.getJSONObject("current").getDouble("wind_kph");
        return answer;
}
```

I added the java swing library to my code and made a **Jpanel** to add  components  to it later.

```java
JPanel panel = new JPanel();
panel.setLayout(null);
panel.setBackground(new Color(193,219,234));
```

the components that I added are 5 **Jlabels** to show the data that I extracted from the **JSON** file and the icon of the window that shows the data.

```java
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
```

for the last part I cleaned up my code , added some comments , and committed the `second assignment` folder for the last time.