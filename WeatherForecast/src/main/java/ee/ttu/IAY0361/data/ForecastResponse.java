package ee.ttu.IAY0361.data;

public class ForecastResponse {
	
	public String city;
	public Days forecastOfDays;
	public double coordinatesLon;
	public double coordinatesLat;
	
	public ForecastResponse(String city, Days forecastOfDays, double coordinatesLon, double coordinatesLat) {
		this.city = city;
		this.forecastOfDays = forecastOfDays;
		this.coordinatesLon = coordinatesLon;
		this.coordinatesLat = coordinatesLat;
	}
}
