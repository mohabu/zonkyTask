package cz.zonky;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class OnlineSource {
	public  int numberOfPujckyOnline = getNumberOfPujckyOnline();
    private URL url;
    private HttpURLConnection hr;
    private BufferedReader br;
    private InputStream im;
    private StringBuffer sb;
    private JSONObject dataToJsonFormat;
    private JSONArray onlineDataArray;
    


	public int getNumberOfPujckyOnline() {
		return Pujcky();
	}

	public URL getUrl() throws MalformedURLException {
		URL url = new URL("https://api.zonky.cz/loans/marketplace");
		return url;
	}
	

	private int Pujcky() {
		int numberOfPucky = 0;
		try {
			    url= getUrl();
			    
		        hr = (HttpURLConnection) url.openConnection();
			    if (hr.getResponseCode() == 200) {
				im = hr.getInputStream();
				br = new BufferedReader(new InputStreamReader(im));
				String inputText =null;
				sb = new StringBuffer();
				//convert data on https://api.zonky.cz/loans/marketplace in JSON format
				sb.append("{key:");
				while ((inputText = br.readLine()) != null) {
					sb.append(inputText);
				}
				sb.append("}");
				String data = sb.toString();
				  dataToJsonFormat = new JSONObject (data); 
				  onlineDataArray =dataToJsonFormat.getJSONArray("key");
				/* System.out.println(onlineDataArray.length()); */
				  numberOfPucky = onlineDataArray.length();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return numberOfPucky;
	}




}