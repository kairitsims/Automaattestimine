package ee.ttu.IAY0361.main;

public class Forecast {
	
	public String date;
	public double minTemperature;
	public double maxTemperature;
	
	
	public Forecast(double minTemperature, double maxTemperature, String date) {
		this.minTemperature = minTemperature;
		this.maxTemperature = maxTemperature;
		this.date = date;
	}


	@Override
	public String toString() {
		return "Forecast [date=" + date + ", minTemperature=" + minTemperature + ", maxTemperature=" + maxTemperature
				+ "]";
	}
	
	
	
	
	
	

}
