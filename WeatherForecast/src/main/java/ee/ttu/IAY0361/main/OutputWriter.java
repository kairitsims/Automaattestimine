package ee.ttu.IAY0361.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputWriter {
	
	public void writeOutputToFile(String output) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("C:/Users/Kairit/Documents/GitHub/Automaattestimine/WeatherForecast/output.txt", true), true);
	    out.write(output);
	    out.close();
	}

}
