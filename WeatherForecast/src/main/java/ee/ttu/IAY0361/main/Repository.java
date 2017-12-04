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

import ee.ttu.IAY0361.data.Days;
import ee.ttu.IAY0361.data.Forecast;
import ee.ttu.IAY0361.data.ForecastResponse;
import ee.ttu.IAY0361.data.Request;
import ee.ttu.IAY0361.data.WeatherResponse;

public class Repository {
	
	public WeatherResponse getWeather(Request request) throws IOException, JSONException {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + request.city + "&APPID=" + request.id + "&units=" + request.unit;
        JSONObject json = ConnectionMaker.connectHttpURL(url);
        JSONObject main = json.getJSONObject("main");
        JSONObject coord = json.getJSONObject("coord");
        WeatherResponse response = new WeatherResponse(json.getString("name"), main.getDouble("temp"), coord.getDouble("lon"), coord.getDouble("lat"));
        return response;
    }

    public ForecastResponse getForecast(Request request) throws JSONException, IOException {
    	
    	String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + request.city + "&APPID=" + request.id + "&units=" + request.unit;
        JSONObject json = ConnectionMaker.connectHttpURL(url);        
        JSONObject city = json.getJSONObject("city");
        JSONObject coord = city.getJSONObject("coord");
        JSONArray list = json.getJSONArray("list"); 
	    
	    List<JSONObject> dayOne = new ArrayList<JSONObject>();
	    List<JSONObject> dayTwo = new ArrayList<JSONObject>();
	    List<JSONObject> dayThree = new ArrayList<JSONObject>();
	    List<Double> dayOneTemps = new ArrayList<Double>();
	    List<Double> dayTwoTemps = new ArrayList<Double>();
	    List<Double> dayThreeTemps = new ArrayList<Double>();
	    
	    Calendar cal1 = Calendar.getInstance();
	    cal1.add(Calendar.DATE, 1);
	    Calendar cal2 = Calendar.getInstance();
	    cal2.add(Calendar.DATE, 2);
	    Calendar cal3 = Calendar.getInstance();
	    cal3.add(Calendar.DATE, 3);
	    
	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	    String formattedDate1 = format1.format(cal1.getTime());
	    String formattedDate2 = format1.format(cal2.getTime());
	    String formattedDate3 = format1.format(cal3.getTime());
	    
        for (int i = 0; i < list.length(); i++) { 
            JSONObject obj = list.getJSONObject(i);
            if(obj.get("dt_txt").toString().contains(formattedDate1)) {
            	dayOne.add(obj);
            }
            else if(obj.get("dt_txt").toString().contains(formattedDate2)) {
            	dayTwo.add(obj);
            }
            else if(obj.get("dt_txt").toString().contains(formattedDate3)) {
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
        Forecast forecast1 = new Forecast(Collections.min(dayOneTemps), Collections.max(dayOneTemps), formattedDate1);
        Forecast forecast2 = new Forecast(Collections.min(dayTwoTemps), Collections.max(dayTwoTemps), formattedDate2);
        Forecast forecast3 = new Forecast(Collections.min(dayThreeTemps), Collections.max(dayThreeTemps), formattedDate3);
        
        Days days = new Days(forecast1, forecast2, forecast3);
        
        ForecastResponse response = new ForecastResponse(city.getString("name"), days, coord.getDouble("lon"), coord.getDouble("lat"));
        return response;
    }

}
