package ee.ttu.IAY0361.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.junit.BeforeClass;
import org.junit.Test;

import ee.ttu.IAY0361.data.Days;
import ee.ttu.IAY0361.data.ForecastResponse;
import ee.ttu.IAY0361.data.Request;
import ee.ttu.IAY0361.data.WeatherResponse;
import ee.ttu.IAY0361.main.InputAsker;
import ee.ttu.IAY0361.main.OutputWriter;
import ee.ttu.IAY0361.main.Repository;

public class RepositoryTest {
	
    private static Request request;
    private static WeatherResponse weatherResponse;
    private static ForecastResponse forecastResponse;
   
    
    @BeforeClass
    public static void setUpAllTests() throws IOException, JSONException, ParseException {
        // [given]
    	InputAsker inputAsker = new InputAsker();
    	Repository repository = new Repository();
    	OutputWriter outputWriter = new OutputWriter();
    	ArrayList<String> listOfCities = new ArrayList<String>();
    	//listOfCities = inputAsker.getCityFromConsole();
    	listOfCities = inputAsker.getCityFromFile();
    	for(String city: listOfCities) {
    		request = new Request(city, "metric", "e21ac4bd7a018f490caf6012bd2f904b");
	        try{
	            // [when]
	            weatherResponse = repository.getWeather(request);
	            forecastResponse = repository.getForecast(request);
	            outputWriter.writeWeatherOutputToFile(request.city, weatherResponse);
	        	outputWriter.writeForecastOutputToFile(request.city, forecastResponse);
	        }catch(Exception e){
	            fail("All test will be ignored, cause: " + e.getMessage());
	        }
    	}
    }
    
    @Test
    public void testIfCorrectCityIsReturned() throws IOException, JSONException {
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
    public void testIfWeatherResponsesCoordinatesAreCorrect() {
        try{
            // [given]
            Repository repository = new Repository();
            // [when]
            WeatherResponse weatherResponse = repository.getWeather(request);
            // [then]
            assertTrue(weatherResponse.coordinatesLat < 90);
            assertTrue(weatherResponse.coordinatesLat > -90);
            assertTrue(weatherResponse.coordinatesLon < 180);
            assertTrue(weatherResponse.coordinatesLon > -180);
        }catch(Exception e){
            fail("Test failed, cause: " + e.getMessage());
        }
    }
    
    @Test
    public void testIfForecastResponsesCoordinatesAreCorrect() {
        try{
            // [given]
            Repository repository = new Repository();
            // [when]
            ForecastResponse forecastResponse = repository.getForecast(request);
            // [then]
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
    public void testIfDay1MinAndMaxTemperaturesAreCorrect() {
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
        }catch(Exception e){
            fail("Test failed, cause: " + e.getMessage());
        
        }
    }
    
    @Test
    public void testIfDay2MinAndMaxTemperaturesAreCorrect() {
        try{
            // [given]
        	Repository repository = new Repository();
            // [when]
        	ForecastResponse forecastResponse = repository.getForecast(request);
        	Days days = forecastResponse.forecastOfDays;
            // [then]
            assertTrue(days.day2.maxTemperature < 50);
            assertTrue(days.day2.minTemperature > -50);
            assertTrue(days.day2.minTemperature < days.day2.maxTemperature);
        }catch(Exception e){
            fail("Test failed, cause: " + e.getMessage());
        
        }
    }
    
    @Test
    public void testIfDay3MinAndMaxTemperaturesAreCorrect() {
        try{
            // [given]
        	Repository repository = new Repository();
            // [when]
        	ForecastResponse forecastResponse = repository.getForecast(request);
        	Days days = forecastResponse.forecastOfDays;
            // [then]
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
