package ee.ttu.IAY0361.main;

public class Days {

	public Forecast day1;
	public Forecast day2;
	public Forecast day3;
	
	
	public Days(Forecast day1, Forecast day2, Forecast day3) {
		super();
		this.day1 = day1;
		this.day2 = day2;
		this.day3 = day3;
	}


	@Override
	public String toString() {
		return "Days [day1=" + day1 + ", day2=" + day2 + ", day3=" + day3 + "]";
	}	
	
	

}
