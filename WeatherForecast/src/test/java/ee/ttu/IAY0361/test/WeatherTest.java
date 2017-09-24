package ee.ttu.IAY0361.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ee.ttu.IAY0361.main.Weather;

public class WeatherTest {
	
	Weather weather;
	
	@Before
	public void setUp() throws Exception {
		weather = new Weather();
	}
		
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
	public void testIfCoordinatesAreAvailable() {
		//koordinaadid on kujul lat: 59.437, lon: 24.7535
		assertNotNull(weather.getCoordinates());
		assertTrue(weather.getCoordinates().contains("lat:"));
		assertTrue(weather.getCoordinates().contains("lon:"));
		assertTrue(weather.getCoordinates().length() <= 26);
	}
	
	@Test
	public void testIfMinTemperatureIsLowerThanMaxTemperature() {
		assertTrue(weather.getTodayPlusOneMin() < weather.getTodayPlusOneMax());
		assertTrue(weather.getTodayPlusTwoMin() < weather.getTodayPlusTwoMax());	
		assertTrue(weather.getTodayPlusThreeMin() < weather.getTodayPlusThreeMax());	
	}
	
}
