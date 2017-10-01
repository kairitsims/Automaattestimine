package ee.ttu.IAY0361.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ee.ttu.IAY0361.main.Forecast;
import ee.ttu.IAY0361.main.ForecastResponse;
import ee.ttu.IAY0361.main.Repository;
import ee.ttu.IAY0361.main.Request;
import ee.ttu.IAY0361.main.WeatherResponse;

public class RepositoryTest {
	
	private String city;
    private String codeOfCountry;
    private String unit;
    private static WeatherResponse weatherResponse;
    private static ForecastResponse forecastResponse;
    private static Request request;
    
   

    @BeforeAll
    // runs only once per class (for expensive shared resources/operations)
    // since the report is only read and not altered, we can initiate one for all the tests.
    public static void setUpAllTests() {
        // [given]
        request = new Request("Tallinn", "EE", "metric", "e21ac4bd7a018f490caf6012bd2f904b");
        Repository repository = new Repository();
        try{
            // [when]
            weatherResponse = repository.getWeather(request);
            forecastResponse = repository.getForecast(request);
        }catch(Exception e){
            fail("All test will be ignored, cause: " + e.getMessage());
        }
    }
    
    @Test
    public void testIfCorrectCityIsReturned() {
        try{
            // [given]
            Repository repository = new Repository();
            // [when]
            WeatherResponse weatherResponse = repository.getWeather(request);
            ForecastResponse forecastResponse = repository.getForecast(request);
            // [then]
            assertEquals(request.city, weatherResponse.city);
            assertEquals(request.city, forecastResponse.city);
        }catch(Exception e){
            fail("Test failed, cause: " + e.getMessage());
        }
    }

    @Test
    public void testIfCoordinatesAreCorrect() {
        try{
            // [given]
            Repository repository = new Repository();
            // [when]
            WeatherResponse weatherResponse = repository.getWeather(request);
            ForecastResponse forecastResponse = repository.getForecast(request);
            // [then]
            assertTrue(weatherResponse.coordinatesLat < 90);
            assertTrue(weatherResponse.coordinatesLat > -90);
            assertTrue(weatherResponse.coordinatesLon < 180);
            assertTrue(weatherResponse.coordinatesLon > -180);
            assertTrue(forecastResponse.coordinatesLat < 90);
            assertTrue(forecastResponse.coordinatesLat > -90);
            assertTrue(forecastResponse.coordinatesLon < 180);
            assertTrue(forecastResponse.coordinatesLon > -180);
        }catch(Exception e){
            fail("Test failed, cause: " + e.getMessage());
        }
    }

    @Test
    public void testIfTempertureIsCorrect() {
        try{
            // [given]
        	Repository repository = new Repository();
            // [when]
        	WeatherResponse weatherResponse = repository.getWeather(request);
            // [then]
        	assertTrue(weatherResponse.temperature < 50);
            assertTrue(weatherResponse.temperature > -50);
        }catch(Exception e){
            fail("Test failed, cause: " + e.getMessage());
        }
    }
	
    @Test
    public void testIfMinAndMaxTemperaturesAreCorrect() {
        try{
            // [given]
        	Repository repository = new Repository();
            // [when]
        	ForecastResponse forecastResponse = repository.getForecast(request);
            // [then]
        	for(Forecast forecast:forecastResponse.forecast) {
        		assertTrue(forecast.maxTemperature < 50);
                assertTrue(forecast.minTemperature > -50);
                assertTrue(forecast.minTemperature < forecast.maxTemperature);
        	}
        }catch(Exception e){
            fail("Test failed, cause: " + e.getMessage());
        
        }
    }
    
    @Test
    public void testIfForecastResponsesWeatherForThreeDays(){
        try{
        	// [given]
            Repository repository = new Repository();
            // [when]
        	ForecastResponse forecastResponse = repository.getForecast(request);
        	// [then]
            assertTrue(forecastResponse.forecast.length == 3);
        }catch (Exception e){
            fail("Test failed, cause: " + e.getMessage());
        }
    }
    
    @Test
    public void testIfForecastResponsesCorrectDates(){
        try{
        	// [given]
            Repository repository = new Repository();
            Date date = new Date();
            // [when]
        	ForecastResponse forecastResponse = repository.getForecast(request);
        	// [then]
            assertTrue(forecastResponse.forecast[0].date.getDate() == date.getDate() + 86400000);
            assertTrue(forecastResponse.forecast[1].date.getDate() == date.getDate() + 2*86400000);
            assertTrue(forecastResponse.forecast[2].date.getDate() == date.getDate() + 3*86400000);
        }catch (Exception e){
            fail("Test failed, cause: " + e.getMessage());
        }
    }
	
}
