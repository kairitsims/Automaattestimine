package ee.ttu.IAY0361.main;

public class ForecastResponse {
	
	public String city;
	public String units;	
	public Days forecastOfDays;
	public double coordinatesLon;
	public double coordinatesLat;
	
	public ForecastResponse(String city, String units, Days forecastOfDays, double coordinatesLon, double coordinatesLat) {
		this.city = city;
		this.units = units;
		this.forecastOfDays = forecastOfDays;
		this.coordinatesLon = coordinatesLon;
		this.coordinatesLat = coordinatesLat;
	}

}
