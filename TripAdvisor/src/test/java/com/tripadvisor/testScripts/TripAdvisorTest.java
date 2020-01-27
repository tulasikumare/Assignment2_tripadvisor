package com.tripadvisor.testScripts;

import org.testng.annotations.Test;

import com.tripadvisor.lib.BaseTest;
import com.tripadvisor.pages.TripAdvisor;

public class TripAdvisorTest extends BaseTest{
	@Test
	public void script()
	{	// creating object for pAdvisor  POM class
		TripAdvisor adv=new TripAdvisor(driver);
		adv.tripAdvisor1();
	}
}
