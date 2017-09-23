package ee.ttu.IAY0361.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ee.ttu.IAY0361.main.Weather;

public class WeatherTest {
	
	Weather weather = new Weather();
	
	@Test
	public void testIfTodaysDataIsAvailable() {
		Date date = new Date();
		assertEquals(weather.getTodaysDate(), date.getTime());
	}
	
	@Test
	public void testIfThreeNextDaysDataIsAvilable() {
		Date date = new Date();
		assertEquals(weather.getTodayPlusOneDate(), date.getTime() + 86400000);
		assertEquals(weather.getTodayPlusTwoDate(), date.getTime() + 2*86400000);
		assertEquals(weather.getTodayPlusThreeDate(), date.getTime() + 3*86400000);
	}
	
	@Test
	public void testCoordinatesAreAvailable() {
		//koordinaadid on kujul lat: 59.437, lon: 24.7535
		assertNotNull(weather.getCoordinates());
		assertTrue(weather.getCoordinates().contains("lat:"));
		assertTrue(weather.getCoordinates().contains("lon:"));
		assertTrue(weather.getCoordinates().length() <= 26);
		
	}
	
	@Test
	public void testIfMinTempIsAvailable() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testIfMaxTempIsAvilable() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testIfMaxTempIsGreaterThanMinTemp() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testIfCoordinatesAreAvilable() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testIfCoordinatesAreInRightForm() {
		fail("Not yet implemented");
	}

}
