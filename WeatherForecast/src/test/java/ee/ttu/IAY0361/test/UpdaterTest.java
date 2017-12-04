package ee.ttu.IAY0361.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import ee.ttu.IAY0361.main.InputAsker;
import ee.ttu.IAY0361.main.Repository;
import ee.ttu.IAY0361.main.Updater;

public class UpdaterTest {

	@Test
	public void testIfUpdaterWorksWithFile() throws IOException, ParseException, JSONException {
		Updater updater = new Updater();
		InputAsker inputAsker = new InputAsker();
		Repository repository = new Repository();
		assertEquals(updater.getRequests(repository).size(), inputAsker.getCityFromFile().size());
	}
	
	/*@Test
	public void testIfUpdaterWorksWithConsole() throws IOException, ParseException, JSONException {
		Updater updater = new Updater();
		InputAsker inputAsker = new InputAsker();
		Repository repository = new Repository();
		assertEquals(updater.getRequests(repository).size(), inputAsker.getCityFromConsole().size());
	}*/


}
