package seleniumMiscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;

public class MaximizingWindowsAndDeletingCookies {

	public static void main(String[] args) {
		
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverPropertyChrome(),configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize(); //Maximize the window
		driver.manage().deleteAllCookies(); //Deletes all the cookies so that no autopopup should be generated
		//driver.manage().deleteCookieNamed("<String>"); //Delete a specific cookie takes string input
	}

}
