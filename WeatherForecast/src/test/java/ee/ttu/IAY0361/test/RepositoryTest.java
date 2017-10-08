package ee.ttu.IAY0361.test;

import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import ee.ttu.IAY0361.main.Days;
import ee.ttu.IAY0361.main.ForecastResponse;
import ee.ttu.IAY0361.main.Repository;
import ee.ttu.IAY0361.main.Request;
import ee.ttu.IAY0361.main.WeatherResponse;

public class RepositoryTest {
	
    private static Request request;
    private static WeatherResponse weatherResponse;
    private static ForecastResponse forecastResponse;
   

    @Before
    public void setUpAllTests() {
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
        	Days days = forecastResponse.forecastOfDays;
            // [then]
        	assertTrue(days.day1.maxTemperature < 50);
            assertTrue(days.day1.minTemperature > -50);
            assertTrue(days.day1.minTemperature < days.day1.maxTemperature);
            assertTrue(days.day2.maxTemperature < 50);
            assertTrue(days.day2.minTemperature > -50);
            assertTrue(days.day2.minTemperature < days.day2.maxTemperature);
            assertTrue(days.day3.maxTemperature < 50);
            assertTrue(days.day3.minTemperature > -50);
            assertTrue(days.day3.minTemperature < days.day3.maxTemperature);
        }catch(Exception e){
            fail("Test failed, cause: " + e.getMessage());
        
        }
    }
    
    @Test
    public void testIfForecastResponsesCorrectDates(){
        try{
        	// [given]
            Repository repository = new Repository();
            Calendar cal1 = Calendar.getInstance();
    	    cal1.add(Calendar.DATE, 1);
    	    Calendar cal2 = Calendar.getInstance();
    	    cal2.add(Calendar.DATE, 2);
    	    Calendar cal3 = Calendar.getInstance();
    	    cal3.add(Calendar.DATE, 3);
    	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    	    String formatted1 = format1.format(cal1.getTime());
    	    String formatted2 = format1.format(cal2.getTime());
    	    String formatted3 = format1.format(cal3.getTime());
            // [when]
        	ForecastResponse forecastResponse = repository.getForecast(request);
        	Days days = forecastResponse.forecastOfDays;
        	// [then]
            assertEquals(days.day1.date, formatted1.toString());
            assertEquals(days.day2.date, formatted2.toString());
            assertEquals(days.day3.date, formatted3.toString());
        }catch (Exception e){
            fail("Test failed, cause: " + e.getMessage());
        }
    }
	
}
