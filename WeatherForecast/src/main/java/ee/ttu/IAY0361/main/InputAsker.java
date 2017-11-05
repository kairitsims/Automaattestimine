package ee.ttu.IAY0361.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InputAsker {
	
	public String getCity() throws IOException {
		System.out.println("Do you wish to enter input form console or from file?");
		String city = "";
		Scanner reader = new Scanner(System.in);
		String answer = reader.nextLine();
		if(answer.equals("console")) {
			city = getCityFromConsole();
		}else if(answer.equals("file")) {
			city = getCityFromFile();
		}else {
			System.out.println("Wrong answer!");
		}
		reader.close();
		return city;
	}
	
	public String getCityFromConsole() {
    	System.out.println("Enter a city: ");
    	Scanner reader = new Scanner(System.in);
		String city = reader.nextLine();
		reader.close();
		return city;
    }
	
	public String getCityFromFile() throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/Kairit/Documents/GitHub/Automaattestimine/WeatherForecast/input.txt"))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String city = sb.toString().trim();
		    return city;
		}
    }

}
