package ee.ttu.IAY0361.main;

import java.util.Date;

public class Weather {
	
	private Date todaysDate;
	private Date todayPlusOneDate;
	private Date todayPlusTwoDate;
	private Date todayPlusThreeDate;
	private String coordinates;
	private double currentTemperature;
	
	
	
	public double getCurrentTemperature() {
		return currentTemperature;
	}
	public Date getTodaysDate() {
		return todaysDate;
	}
	public Date getTodayPlusOneDate() {
		return todayPlusOneDate;
	}
	public Date getTodayPlusTwoDate() {
		return todayPlusTwoDate;
	}
	public Date getTodayPlusThreeDate() {
		return todayPlusThreeDate;
	}
	public String getCoordinates() {
		return coordinates;
	}
	
	

	

}
