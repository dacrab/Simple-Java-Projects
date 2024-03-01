import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherForecastApp {
    private static final String API_KEY = "YOUR_API_KEY_HERE"; // Replace with your OpenWeatherMap API key

    public static void main(String[] args) {
        // Code to interact with the OpenWeatherMap API
        // You can use libraries like Gson to parse JSON responses
        // This is just a basic example to demonstrate the concept

        try {
            String city = "London"; // Example city (you can allow users to input their desired location)
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Print the weather forecast data (you can parse and display specific information as needed)
            System.out.println("Weather Forecast for " + city + ":");
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
