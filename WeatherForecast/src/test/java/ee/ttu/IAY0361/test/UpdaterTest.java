package ee.ttu.IAY0361.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import ee.ttu.IAY0361.main.InputAsker;
import ee.ttu.IAY0361.main.OutputWriter;
import ee.ttu.IAY0361.main.Repository;
import ee.ttu.IAY0361.main.Updater;

public class UpdaterTest {

	@Test
	public void testIfUpdaterWorksWithFile() throws IOException, ParseException, JSONException {
		Updater updater = new Updater();
		InputAsker inputAsker = new InputAsker();
		Repository repository = new Repository();
		OutputWriter outputWriter = new OutputWriter();
		assertEquals(updater.writeFilesAndReturnListOfCities(repository, inputAsker, outputWriter).size(), inputAsker.getCityFromFile().size());
	}
	
	/*@Test
	public void testIfUpdaterWorksWithConsole() throws IOException, ParseException, JSONException {
		Updater updater = new Updater();
		InputAsker inputAsker = new InputAsker();
		Repository repository = new Repository();
		OutputWriter outputWriter = new OutputWriter();
		assertEquals(updater.writeFilesAndReturnListOfCities(repository, inputAsker, outputWriter).size(), inputAsker.getCityFromConsole().size());
	}*/
	
	@Test
	public void testUpdaterWithInputReaderMock() throws IOException, ParseException, JSONException {
		InputAsker inputAskerMock = mock(InputAsker.class);
		Repository repositoryMock = mock(Repository.class);
		Updater updater = new Updater();
		OutputWriter outputWriter = new OutputWriter();
		ArrayList<String> listOfCitiesDummy = new ArrayList<String>();
		listOfCitiesDummy.add("Tallinn");
		listOfCitiesDummy.add("Dummy");
		when(inputAskerMock.getCityFromFile()).thenReturn(listOfCitiesDummy);
		
		assertEquals(updater.writeFilesAndReturnListOfCities(repositoryMock, inputAskerMock, outputWriter), listOfCitiesDummy);
	}
	


}
