package com.tripadvisor.pages;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.tripadvisor.lib.BasePage;
import com.tripadvisor.util.WebActionUtil;

public class TripAdvisor extends BasePage{

	public TripAdvisor(WebDriver driver) {
		super(driver);
	
	}
	// clicking on search button top corner
		@FindBy(xpath = "//div[@title='Search']/span[text()='Search']")
		private WebElement clickingOnSearch;
		// typing text in search box
		@FindBy(xpath = "//div[@class='input_box activeInput']//input[@id='mainSearch']")
		private WebElement clickingOnMainSearchTextBtn;
		// clicking search button
		@FindBy(xpath = "//div[@class='ui_column is-2 search_line_block is-gapless']/button[@id='SEARCH_BUTTON']")
		private WebElement clickingOnMainSearch;
		// clicking search result which is coming first
		@FindBy(xpath = "//div[@class='result-title']/span[contains(.,'Madikeri')]")
		private WebElement clickigOnFirstElemet;
		// clicking on writing review
		@FindBy(xpath = "//div[@class='was-ssr-only']//div[@class='hotels-community-content-common-ContextualCTA__currentOption--3Wd5D']/a[contains(text(),'Write a review')]")
		private WebElement clickigOnWriteReview;
		// selecting overall rating
		@FindBy(xpath = "//div[@class='easyClear bigRatingParent']/span[@id='bubble_rating']")
		private WebElement clickigRating;
		// selecting 5 rating
		@FindBy(xpath = "//span[@id='bubble_rating']/img")
		private WebElement clickigRating5;
		// selecting 5 rating in hotel ratings
		@FindBy(xpath = "//span[@id='qid12_bubbles']/img")
		private WebElement clickigHotelRating5;

		// typing title of your review
		@FindBy(xpath = "//div[@id='REVIEW_TITLE']/input[@id='ReviewTitle']")
		private WebElement titleYourReview;
		// typing of your review
		@FindBy(xpath = "//div[@id='REVIEW_TEXT']/textarea[@id='ReviewText']")
		private WebElement YourReview;

		// selecting check box in submit your review
		@FindBy(xpath = "//div[@class='willing ']/input[@id='noFraud']")
		private WebElement checkboxSelectReview;
			
	public void tripAdvisor1()
	{
			WebActionUtil.sleep(600);
			WebActionUtil.clickOnElement(clickingOnSearch, "clickingOnSearch");
			WebActionUtil.sleep(700);
			System.out.println(clickingOnMainSearchTextBtn.isDisplayed());
			WebActionUtil.typingTheText(clickingOnMainSearchTextBtn, "Club Mahindra", "typing clubmahindra");
			WebActionUtil.clickOnElement(clickingOnMainSearch, "clicking on search");
			WebActionUtil.sleep(900);
			WebActionUtil.clickOnElement(clickigOnFirstElemet, "selecting first visibility search result");

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			// navigating to next tab
			driver.switchTo().window(tabs2.get(1));
			WebActionUtil.sleep(700);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).perform();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,2750)");
			WebActionUtil.sleep(200);

			WebActionUtil.clickOnElement(clickigOnWriteReview, "Writing the review");
			ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
			// navigating to next tab
			driver.switchTo().window(tabs3.get(2));

			action.moveToElement(clickigRating5, 155, 0).click().build().perform();
			WebActionUtil.typingTheText(titleYourReview, "Wonderful stay", "typing your review");
			WebActionUtil.typingTheText(YourReview,
					"We liked the hotel, personal, and particularly Furkan and Dilip and Kontal from housekeeping. Room service was very well, kitchen was very tasty. Swimming pool was clean, towels always fresh. "
							+ "Recommend everybody to visit",
					"typing review");
			jse.executeScript("window.scrollBy(0,1250)");
			action.moveToElement(clickigHotelRating5, 115, 32).click().build().perform();
			jse.executeScript("window.scrollBy(0,1450)");
			WebActionUtil.clickOnElement(checkboxSelectReview, "selecting check box");
	}
}
