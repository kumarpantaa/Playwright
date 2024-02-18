package day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class InputInteractionsWithLamdaTestPage {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		String URL = "https://www.lambdatest.com/selenium-playground/simple-form-demo";
		page.navigate(URL);
		
		//1.Single Input Field
		//Enter Message
		Locator enterMessageTextBox = page.locator("//input[@id='user-message']");
		String inputText = "Playwright";
		enterMessageTextBox.fill(inputText);
		
		//Click Get Checked Value Button
		Locator getCheckedValueButton = page.locator("#showInput");
		getCheckedValueButton.click();
		
		Locator yourMessageField = page.locator("//p[@id='message']");
		String yourMessageValue = yourMessageField.textContent();
		System.out.println("Your Message : " + yourMessageValue);
		
		//2.Two Input Fields
		//Enter first value
		Locator enterFirstValueTextBox = page.locator("#sum1");
		enterFirstValueTextBox.fill("50");
		
		//Enter second value
		Locator enterSecondValueTextBox = page.locator("#sum2");
		enterSecondValueTextBox.fill("50");
		
		//Click Get Sum Button
		Locator getSumbutton = page.locator("//button[text()='Get Sum']");
		getSumbutton.click();
		
		Locator resultField = page.locator("//p[@id='addmessage']");
		String resultValue = resultField.textContent();
		System.out.println("Result : " + resultValue);
		
		page.close();
		browser.close();
		playwright.close();
	}
	

}
