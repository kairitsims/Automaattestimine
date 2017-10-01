package ee.ttu.IAY0361.main;

public class ForecastResponse {
	
	public String city;
	public String units;	
	public Forecast[] forecast;
	public double coordinatesLon;
	public double coordinatesLat;
	
	public ForecastResponse(String city, String units, Forecast[] forecast, double coordinatesLon, double coordinatesLat) {
		this.city = city;
		this.units = units;
		this.forecast = forecast;
		this.coordinatesLon = coordinatesLon;
		this.coordinatesLat = coordinatesLat;
	}

}
