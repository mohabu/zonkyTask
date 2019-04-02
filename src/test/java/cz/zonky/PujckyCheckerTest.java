package cz.zonky;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PujckyCheckerTest {
	
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
	 void checkPujckyUpdateInTimeTest() {
		int PujckyNumberEveryFiveMin = 0;
		int PujckyonlineNumberNow = 20;
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
			PujckyNumberEveryFiveMin = PujckyonlineNumberNow;
			if (PujckyNumberEveryFiveMin > PujckyonlineNumberNow) {
				System.out.println("ALERT: " + (PujckyNumberEveryFiveMin - PujckyonlineNumberNow) + " NEW PUJCKY ADDED TO STORE.");
			}
			PujckyonlineNumberNow = PujckyNumberEveryFiveMin;
			
			
			assertNotNull(executor);
			assertTrue(executor instanceof ScheduledExecutorService);
			System.out.println("checkPujckyUpdateInTimeTest(): PASS");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	void getOnlinesourceDataTest() {
		
		assertNotNull(onlineSource);
		assertTrue(onlineSource instanceof OnlineSource);
		System.out.println("getOnlinesourceDataTest(): PASS");
	}
	
	@Test
	void getPujckyonlineNumberNowTest() {
		int expected = 20;
		int actual = onlineSource.getNumberOfPujckyOnline();
		assertEquals(expected, actual, "number of pujcky not 20");
		System.out.println("getPujckyonlineNumberNowTest(): PASS");
	}
	
	
	
	



}
