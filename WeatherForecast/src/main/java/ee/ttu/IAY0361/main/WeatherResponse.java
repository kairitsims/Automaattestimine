package ee.ttu.IAY0361.main;

public class WeatherResponse {
	
	public String city;	
	public double temperature;
	public double coordinatesLon;
	public double coordinatesLat;
	
	public WeatherResponse(String city, double temperature, double coordinatesLon, double coordinatesLat) {
		this.city = city;
		this.temperature = temperature;
		this.coordinatesLon = coordinatesLon;
		this.coordinatesLat = coordinatesLat;
	}

	@Override
	public String toString() {
		return "WeatherResponse [city=" + city + ", temperature=" + temperature + ", coordinatesLon=" + coordinatesLon
				+ ", coordinatesLat=" + coordinatesLat + "]";
	}
	
	

}
