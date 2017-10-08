package ee.ttu.IAY0361.test;

import static org.junit.Assert.*;

import java.net.HttpURLConnection;

import org.json.JSONObject;
import org.junit.Test;

import ee.ttu.IAY0361.main.Connection;

public class ConnectionTest {

	@Test
	public void testIfConnectionToWeatherApiExists() {
		String url = "http://api.openweathermap.org/data/2.5/weather?q=Tallinn,EE&APPID=e21ac4bd7a018f490caf6012bd2f904b&units=metric";
		try {
			JSONObject connection = Connection.connectHttpURL(url);
			assertNotNull(connection);
		} catch (Exception e) {
			System.out.println("Exception occurred");
		}
	}
	
	@Test
	public void testIfConnectionToForecastApiExists() {
		String url = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn,ee&APPID=e21ac4bd7a018f490caf6012bd2f904b&units=metric";
		try {
			JSONObject connection = Connection.connectHttpURL(url);
			assertNotNull(connection);
		} catch (Exception e) {
			System.out.println("Exception occurred");
		}
	}
	
}
