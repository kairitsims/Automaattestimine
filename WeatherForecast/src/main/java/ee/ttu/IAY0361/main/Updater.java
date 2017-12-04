package ee.ttu.IAY0361.main;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import ee.ttu.IAY0361.data.ForecastResponse;
import ee.ttu.IAY0361.data.Request;
import ee.ttu.IAY0361.data.WeatherResponse;

public class Updater {
	
	public ArrayList<String> writeFilesAndReturnListOfCities(Repository repository, InputAsker inputAsker, OutputWriter outputWriter) throws IOException, ParseException, JSONException {
		ArrayList<String> listOfCities = new ArrayList<String>();
    	//listOfCities = inputAsker.getCityFromConsole();
    	listOfCities = inputAsker.getCityFromFile();
    	for(String city: listOfCities) {
    		Request request = new Request(city, "metric", "e21ac4bd7a018f490caf6012bd2f904b");
	        WeatherResponse weatherResponse = repository.getWeather(request);
	        ForecastResponse forecastResponse = repository.getForecast(request);
	        outputWriter.writeWeatherOutputToFile(city, weatherResponse);
	        outputWriter.writeForecastOutputToFile(city, forecastResponse);
    	}
    	return listOfCities;
	}
	
	

}
