package ee.ttu.IAY0361.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.mockito.Mockito;

import ee.ttu.IAY0361.data.Days;
import ee.ttu.IAY0361.data.Forecast;
import ee.ttu.IAY0361.data.ForecastResponse;
import ee.ttu.IAY0361.data.Request;
import ee.ttu.IAY0361.data.WeatherResponse;
import ee.ttu.IAY0361.main.InputAsker;
import ee.ttu.IAY0361.main.OutputWriter;
import ee.ttu.IAY0361.main.Repository;
import ee.ttu.IAY0361.main.Updater;

public class Mocking {

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
	
	@Test
	public void testReadingFromFile() throws IOException, ParseException, JSONException {
		InputAsker inputAskerMock = mock(InputAsker.class);
		ArrayList<String> listOfCitiesDummy = new ArrayList<String>();
		listOfCitiesDummy.add("Tallinn");
		listOfCitiesDummy.add("Dummy");
		when(inputAskerMock.getCityFromFile()).thenReturn(listOfCitiesDummy);
		assertEquals(inputAskerMock.getCityFromFile(), listOfCitiesDummy);
	}
	
	@Test
	public void testFileWriting() throws IOException, JSONException {
		OutputWriter outputWriterMock = mock(OutputWriter.class);
		
		WeatherResponse weatherResponseDummy = new WeatherResponse("Dummy", 0, 0, 0);
		Forecast forecastDummy = new Forecast(0, 0, "20-20-20");
		Days daysDummy = new Days(forecastDummy, forecastDummy, forecastDummy);
		ForecastResponse forecastResponseDummy = new ForecastResponse("Dummy", daysDummy, 0, 0);
		outputWriterMock.writeWeatherOutputToFile(weatherResponseDummy.city, weatherResponseDummy);
		outputWriterMock.writeForecastOutputToFile(forecastResponseDummy.city, forecastResponseDummy);
		verify(outputWriterMock).writeWeatherOutputToFile(weatherResponseDummy.city, weatherResponseDummy);
		verify(outputWriterMock).writeForecastOutputToFile(forecastResponseDummy.city, forecastResponseDummy);
		
	}

}
