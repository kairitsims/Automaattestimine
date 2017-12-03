package ee.ttu.IAY0361.main;

import java.io.FileOutputStream;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.json.JSONException;

import ee.ttu.IAY0361.data.ForecastResponse;
import ee.ttu.IAY0361.data.WeatherResponse;;

public class OutputWriter {
	
	public void writeWeatherOutputToFile(String city, WeatherResponse response) throws IOException, JSONException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		FileOutputStream file = new FileOutputStream("C:/Users/Kairit/Documents/GitHub/Automaattestimine/WeatherForecast/output/"+ city +".json", true);
		writer.writeValue(file, response);		
	}
	
	public void writeForecastOutputToFile(String city, ForecastResponse response) throws IOException, JSONException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		FileOutputStream file = new FileOutputStream("C:/Users/Kairit/Documents/GitHub/Automaattestimine/WeatherForecast/output/"+ city +".json", true);
		writer.writeValue(file, response);
	}
	
	

}
