package SeleniumTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//You need to create an object for the WebDriver to invoke the Browser
		// Object obj = new Object(); //Format for writing an object
		//We will implement the methods of WebDriver
		
		//System.setProperty("webdriver.chrome.driver","D:\\MyJavaLearning\\Drivers\\chromedriver.exe"); //Use double '\\' for escape sequence
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverProperty(),configFileReader.getDriverPath());
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");  //Get the URL in the browser
		System.out.println(driver.getTitle());
		
		
		System.out.println(driver.getCurrentUrl()); //Required to validate the correct URL is entered
		//System.out.println(driver.getPageSource()); //Required where Right Click is disabled
		
		//driver.get("https://yahoo.com");
		//driver.navigate().back(); //Back Button //Working with latest versions //Used to go back to previous page
		//driver.navigate().forward(); //Forward Button
		//driver.close(); // Close the browser window in focus
		//driver.quit(); // Close the complete browser
		
		
		driver.get("https://facebook.com");
		driver.findElement(By.id("email")).sendKeys("sudeshdeulkar95@gmail.com"); // Enter the text in the TextBox located by Id attribute
		driver.findElement(By.name("pass")).sendKeys("password"); // Enter the text in the TextBox located by Name attribute
		//driver.findElement(By.className("inputtext login_form_input_box")).sendKeys("password");
		driver.findElement(By.linkText("Forgotten account?")).click(); // Click the link By using the Anchor tag for the link located by the linkText method
		driver.quit();
		
		/* 
		 * Learnings from the session
		 * 1) ID,Name,ClassName are not always reliable for locating elements as they are given by developers
		 * 2) Alphanumeric characters in ID may change -- Check it by refreshing the page
		 * 3) Xpath and CSS Selector are most widely used locators
		 * 4) Confirm the link with anchor tag
		 * 5) Class name should not have spaces....It will give exception
		 * 6) If multiple elements have same identifier, then Selenium will locate the first element by preference -- Scans from the Top Left
		 * 7) Xpath from Browser tools are not reliable
		 * 8) Before pasting Xpath, replace the double quotes into single quotes for working
		 * 9) Firepath depreciated from latest Firefox
		 * 10) Xpath can be defined in number of ways
		 * 11) Right click on the html code and copy Xpath to get the Xpath using browser tools
		 * 12) When Xpath starts from html, it is not reliable, switch the browser and take another Xpath
		 * 13) There is no direct way to get CSS in Chrome, you need to take it from tools
		 * 14) $("{CssSelector}") = Validate CSS Selector
		 * 15) $x("{Xpath}") = Validate Xpath
		 * 16) Form your own Xpath using Html attributes : //tagName[@attribute='value']
		 * 17) Form your own CSS Path using Html attributes : tagName[attribute='value']
		 * 18) Form your own CSS Path using Html attributes : tagName#id (Only if id attribute is present)
		 * 19) Form your own CSS Path using Html attributes : tagName.class
		 * 20) Xpath Regular Expression : //tagName[contains(@attribute,'value')]
		 * 21) CSS Regular Expression : tagName[attribute*='value']
		 * 22) Parent Child Xpath : Define Xpath for Parent/tagNames
		 * 23) Select class is used to handle the static dropdowns
		 * 24) It can be used only if the select tag is present for the dropdown
 		 * */
		
		
		
		
		
		
		
		
		

	}

}