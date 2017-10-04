package ee.ttu.IAY0361.main;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Repository {
	
	public WeatherResponse getWeather(Request request) throws IOException, JSONException {
		
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + request.city +"," + request.codeOfCountry + "&APPID=" + request.id + "&units=" + request.unit;
        JSONObject json = Connection.connectHttpURL(url);
        JSONObject main = json.getJSONObject("main");
        JSONObject coord = json.getJSONObject("coord");
        
        WeatherResponse response = new WeatherResponse(json.getString("name"), "metric", main.getDouble("temp"), coord.getDouble("lon"), coord.getDouble("lat"));
        return response;
    }

    public ForecastResponse getForecast(Request request) throws JSONException, IOException {
    	
    	String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + request.city +"," + request.codeOfCountry + "&APPID=" + request.id + "&units=" + request.unit;
        JSONObject json = Connection.connectHttpURL(url);        
        JSONObject city = json.getJSONObject("city");
        JSONObject coord = city.getJSONObject("coord");
        JSONArray arr = json.getJSONArray("list"); 
	    
	    List<JSONObject> dayOne = new ArrayList<JSONObject>();
	    List<JSONObject> dayTwo = new ArrayList<JSONObject>();
	    List<JSONObject> dayThree = new ArrayList<JSONObject>();
	    List<Double> dayOneTemps = new ArrayList();
	    List<Double> dayTwoTemps = new ArrayList();
	    List<Double> dayThreeTemps = new ArrayList();
	    
	    Calendar cal1 = Calendar.getInstance();
	    cal1.add(Calendar.DATE, 1);
	    Calendar cal2 = Calendar.getInstance();
	    cal2.add(Calendar.DATE, 2);
	    Calendar cal3 = Calendar.getInstance();
	    cal3.add(Calendar.DATE, 3);
	    
	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	    String formatted1 = format1.format(cal1.getTime());
	    String formatted2 = format1.format(cal2.getTime());
	    String formatted3 = format1.format(cal3.getTime());
	    
        for (int i = 0; i < arr.length(); i++) { 
            JSONObject obj = arr.getJSONObject(i);
            if(obj.get("dt_txt").toString().contains(formatted1)) {
            	dayOne.add(obj);
            }
            else if(obj.get("dt_txt").toString().contains(formatted2)) {
            	dayTwo.add(obj);
            }
            else if(obj.get("dt_txt").toString().contains(formatted3)) {
            	dayThree.add(obj);
            }
        }
        for(int i = 0; i < dayOne.size(); i++) {
        	JSONObject o = dayOne.get(i);
        	JSONObject ob = o.getJSONObject("main");
        	Double temp = ob.getDouble("temp");
        	dayOneTemps.add(temp);
        }
        for(int i = 0; i < dayTwo.size(); i++) {
        	JSONObject o = dayTwo.get(i);
        	JSONObject ob = o.getJSONObject("main");
        	Double temp = ob.getDouble("temp");
        	dayTwoTemps.add(temp);
        }
        for(int i = 0; i < dayThree.size(); i++) {
        	JSONObject o = dayThree.get(i);
        	JSONObject ob = o.getJSONObject("main");
        	Double temp = ob.getDouble("temp");
        	dayThreeTemps.add(temp);
        	
        }
        Forecast forecast1 = new Forecast(Collections.min(dayOneTemps), Collections.max(dayOneTemps), formatted1);
        Forecast forecast2 = new Forecast(Collections.min(dayTwoTemps), Collections.max(dayTwoTemps), formatted2);
        Forecast forecast3 = new Forecast(Collections.min(dayThreeTemps), Collections.max(dayThreeTemps), formatted3);
        Days days = new Days(forecast1, forecast2, forecast3);
        
        ForecastResponse response = new ForecastResponse(city.getString("name"), "metric", days, coord.getDouble("lon"), coord.getDouble("lat"));
        return response;
    }

}
