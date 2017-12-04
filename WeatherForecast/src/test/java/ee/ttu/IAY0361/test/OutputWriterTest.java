package ee.ttu.IAY0361.test;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import java.io.IOException;
import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import ee.ttu.IAY0361.data.ForecastResponse;
import ee.ttu.IAY0361.data.WeatherResponse;
import ee.ttu.IAY0361.main.InputAsker;
import ee.ttu.IAY0361.main.OutputWriter;
import ee.ttu.IAY0361.main.Repository;
import ee.ttu.IAY0361.main.Updater;

public class OutputWriterTest {

	@Test
	public void testFileWriting() throws IOException, JSONException, ParseException {
		OutputWriter outputWriterMock = mock(OutputWriter.class);
		Updater updater = new Updater();
		Repository repository = new Repository();
		InputAsker inputAsker = new InputAsker();
		
		updater.writeFilesAndReturnListOfCities(repository, inputAsker, outputWriterMock);
		
		verify(outputWriterMock, times(inputAsker.getCityFromFile().size())).writeWeatherOutputToFile(anyString(), any(WeatherResponse.class));
		verify(outputWriterMock, times(inputAsker.getCityFromFile().size())).writeForecastOutputToFile(anyString(), any(ForecastResponse.class));
		
	}

}
