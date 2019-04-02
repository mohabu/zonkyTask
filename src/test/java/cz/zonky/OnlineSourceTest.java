package cz.zonky;

import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.*;

class OnlineSourceTest {
	OnlineSource onlineSource = new OnlineSource();

	@BeforeAll
	public static void before() {

		System.out.println("BeforeAll...");
	}

	@AfterAll
	public static void After() {
		System.out.println("AfterAll...");
	}

	@BeforeEach
	public void setup() {
		System.out.println("BeforeEach");
	}

	@AfterEach
	public void tearDown() {
		System.out.println("AfterEach");
	}

	@Test
	void getNumberOfPujckyOnlineTest() {
		int expected = 20;
		int actual = onlineSource.getNumberOfPujckyOnline();
		assertEquals(expected, actual, "number of pujcky not 20");
		System.out.println("getNumberOfPujckyOnlineTest: yes");
	}

	@Test
	void getUrlTest() throws Exception{
	
			URL url = new URL("https://api.zonky.cz/loans/marketplace");
			assertNotNull(url);
			assertTrue(url instanceof URL);
	
		System.out.println("getUrlTest: yes");
	}

	@Test
	void PujckyTest() throws Exception {
		URL url;
		HttpURLConnection hr;
		BufferedReader br = null;
		InputStream im = null;
		StringBuffer sb;
		JSONObject dataToJsonFormat = null;
		JSONArray onlineDataArray = null;
		int numberOfPucky = 0;
		String inputText = null;

		url = new URL("https://api.zonky.cz/loans/marketplace");

		String data = null;
		hr = (HttpURLConnection) url.openConnection();
		if (hr.getResponseCode() == 200) {
			im = hr.getInputStream();
			br = new BufferedReader(new InputStreamReader(im));

			sb = new StringBuffer();
			sb.append("{key:");
			while ((inputText = br.readLine()) != null) {
				sb.append(inputText);
			}
			sb.append("}");
			data = sb.toString();
			dataToJsonFormat = new JSONObject(data);
			onlineDataArray = dataToJsonFormat.getJSONArray("key");
			numberOfPucky = onlineDataArray.length();
		}

		assertNotNull(url);
		assertTrue(url instanceof URL);
		assertNotNull(hr);
		assertTrue(hr instanceof HttpURLConnection);
		assertNotNull(im);
		assertTrue(im instanceof InputStream);
		assertNotNull(br);
		assertTrue(br instanceof BufferedReader);
		assertTrue(data instanceof String);
		assertNotNull(data);
		assertTrue(dataToJsonFormat instanceof JSONObject);
		assertNotNull(dataToJsonFormat);
		assertTrue(onlineDataArray instanceof JSONArray);
		assertNotNull(onlineDataArray);
		int expected = 20;
		int actual = onlineDataArray.length();
		assertEquals(expected, actual, "number of pujcky not 20");
		System.out.println("PujckyTest: yes");

	}

}
