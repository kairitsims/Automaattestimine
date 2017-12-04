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

public class InputAskerTest {
	
	@Test
	public void testInputAskerFromConsole() {
		InputAsker inputAsker = new InputAsker();
		assertEquals(inputAsker.getCityFromConsole().size(), 1);
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

}
