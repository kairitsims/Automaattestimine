package ee.ttu.IAY0361.main;

import java.util.Date;

public class Weather {
	
	private Date todaysDate;
	private Date todayPlusOneDate;
	private Date todayPlusTwoDate;
	private Date todayPlusThreeDate;
	private String coordinates;
	private double currentTemperature;
	private double todayPlusOneMin;
	private double todayPlusOneMax;
	private double todayPlusTwoMin;
	private double todayPlusTwoMax;
	private double todayPlusThreeMin;
	private double todayPlusThreeMax;
	
	
	
	public double getTodayPlusOneMin() {
		return todayPlusOneMin;
	}
	public double getTodayPlusOneMax() {
		return todayPlusOneMax;
	}
	public double getTodayPlusTwoMin() {
		return todayPlusTwoMin;
	}
	public double getTodayPlusTwoMax() {
		return todayPlusTwoMax;
	}
	public double getTodayPlusThreeMin() {
		return todayPlusThreeMin;
	}
	public double getTodayPlusThreeMax() {
		return todayPlusThreeMax;
	}
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
