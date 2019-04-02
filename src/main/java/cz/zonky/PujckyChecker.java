package cz.zonky;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PujckyChecker {
	private OnlineSource onlinesourceData = new OnlineSource();
	private int PujckyonlineNumberNow = getOnlinesourceData().numberOfPujckyOnline;
	public int PujckyNumberEveryFiveMin = 0;

	public PujckyChecker() {
		checkPujckyUpdateInTime();
	}

	public void checkPujckyUpdateInTime() {

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		Runnable task = () -> {
			 // PujckyNumberEveryFiveMin = getPujckyonlineNumberNow() + new Random().nextInt(3);
			PujckyNumberEveryFiveMin = getPujckyonlineNumberNow();
			if (PujckyNumberEveryFiveMin > PujckyonlineNumberNow) {
				System.out.println("ALERT: " + (PujckyNumberEveryFiveMin - PujckyonlineNumberNow) + " NEW PUJCKY ADDED TO STORE.");
			}
			PujckyonlineNumberNow = PujckyNumberEveryFiveMin;
			//System.out.println("onlinenow =" + PujckyonlineNumberNow);
		};
		executor.scheduleWithFixedDelay(task, 0, 5l, TimeUnit.MINUTES);
	}
	

	public OnlineSource getOnlinesourceData() {
		return onlinesourceData;
	}

	public int getPujckyonlineNumberNow() {
		return PujckyonlineNumberNow;
	}

}