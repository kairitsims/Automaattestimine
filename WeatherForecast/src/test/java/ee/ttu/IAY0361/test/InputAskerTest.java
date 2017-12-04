package ee.ttu.IAY0361.test;

import static org.junit.Assert.*;
import java.io.IOException;
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
	public void testInputAskerFromFile() throws IOException, ParseException, JSONException {
		InputAsker inputAsker = new InputAsker();
		assertTrue(inputAsker.getCityFromFile().size()>0);
	}

}
