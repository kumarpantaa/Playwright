package day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowserFirefox {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://www.youtube.com/");
		//Identify the title of the web page.
		String title = page.title();
		System.out.println("Title of the page : " + title);
		
		//Identify the URL of the web page
		String url = page.url();
		System.out.println("URL of the page : " + url);
		
		page.close();
		browser.close();
		playwright.close();
		
	}

}
