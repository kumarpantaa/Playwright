package day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class InputInteractionsWithLetCodePage {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
		Page page = browser.newPage();

		String URL = "https://letcode.in/edit";
		page.navigate(URL);

		//Enter your full Name
		page.locator("#fullName").fill("Kumar Pantaa");

		//Append a text and press keyboard tab
		Locator appendTextBoxElement = page.locator("#join");
		appendTextBoxElement.press("End");
		appendTextBoxElement.type(" in selenium and playwright");
		appendTextBoxElement.press("Tab");
		
		//What is inside the text box
		String textInTheBox = page.locator("#getMe").getAttribute("value");
		System.out.println("Text inside the box : " + textInTheBox);
		
		//Clear the text
		Locator clearTextBox = page.locator("//input[@id='clearMe']");
		clearTextBox.clear();
		
		//Confirm edit field is disabled
		Locator disabledTextBox = page.locator("//input[@id='noEdit']");
		boolean disabled = disabledTextBox.isDisabled();
		System.out.println("Is the textbox disabled? : " +disabled);
		
		//Confirm text is read-only
		Locator readOnlyTextBox = page.locator("//input[@id='dontwrite']");
		boolean editable = readOnlyTextBox.isEditable();
		System.out.println("Is the textbox is editable? : "+editable);
		
		page.close();
		browser.close();
		playwright.close();
		
	}
}
