package ee.ttu.IAY0361.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Test;

import ee.ttu.IAY0361.data.Days;
import ee.ttu.IAY0361.data.Forecast;
import ee.ttu.IAY0361.data.ForecastResponse;
import ee.ttu.IAY0361.data.WeatherResponse;
import ee.ttu.IAY0361.main.OutputWriter;

public class OutputWriterTest {

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
