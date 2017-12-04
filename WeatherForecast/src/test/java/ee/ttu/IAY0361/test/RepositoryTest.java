package ee.ttu.IAY0361.test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.junit.BeforeClass;
import org.junit.Test;

import ee.ttu.IAY0361.data.Days;
import ee.ttu.IAY0361.data.Forecast;
import ee.ttu.IAY0361.data.ForecastResponse;
import ee.ttu.IAY0361.data.Request;
import ee.ttu.IAY0361.data.WeatherResponse;
import ee.ttu.IAY0361.main.InputAsker;
import ee.ttu.IAY0361.main.OutputWriter;
import ee.ttu.IAY0361.main.Repository;
import ee.ttu.IAY0361.main.Updater;

public class RepositoryTest {
	
    private static Request request;
    private static WeatherResponse weatherResponse;
    private static ForecastResponse forecastResponse;
   
    
    @BeforeClass
    public static void setUpAllTests() throws IOException, JSONException, ParseException {
    	Repository repository = new Repository();
    	Updater updater = new Updater();
    	ArrayList<String> listOfCities = updater.getRequests(repository);
    	for(String city: listOfCities) {
    		request = new Request(city, "metric", "e21ac4bd7a018f490caf6012bd2f904b");
	        try{
	            weatherResponse = repository.getWeather(request);
	            forecastResponse = repository.getForecast(request);
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
    
    @Test
	public void testIfEveryInputHasAnOutput() throws IOException, JSONException, ParseException {
		Repository repositoryMock = mock(Repository.class);
		Updater update = new Updater();
		WeatherResponse weatherResponseDummy = new WeatherResponse("Dummy", 0, 0, 0);
		Forecast forecastDummy = new Forecast(0, 0, "20-20-20");
		Days daysDummy = new Days(forecastDummy, forecastDummy, forecastDummy);
		ForecastResponse forecastResponseDummy = new ForecastResponse("Dummy", daysDummy, 0, 0);
		when(repositoryMock.getWeather(any(Request.class))).thenReturn(weatherResponseDummy);
		when(repositoryMock.getForecast(any(Request.class))).thenReturn(forecastResponseDummy);
		int nrOfRequests = update.getRequests(repositoryMock).size();
		int nrOfOutputFilesCreated= new File("C:/Users/Kairit/Documents/GitHub/Automaattestimine/WeatherForecast/output").listFiles().length;
		assertEquals(nrOfRequests, nrOfOutputFilesCreated);
	}
	
}
