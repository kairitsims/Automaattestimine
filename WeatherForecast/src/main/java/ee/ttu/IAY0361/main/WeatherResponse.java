package ee.ttu.IAY0361.main;

public class WeatherResponse {
	
	public String city;
	public String units;	
	public double temperature;
	public double coordinatesLon;
	public double coordinatesLat;
	
	public WeatherResponse(String city, String units, double temperature, double coordinatesLon, double coordinatesLat) {
		this.city = city;
		this.units = units;
		this.temperature = temperature;
		this.coordinatesLon = coordinatesLon;
		this.coordinatesLat = coordinatesLat;
	}

}
