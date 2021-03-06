package SeleniumTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataProvider.ConfigFileReader;

public class FirefoxSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//You need to create an object for the WebDriver to invoke the Browser
		// Object obj = new Object(); //Format for writing an object
		//We will implement the methods of WebDriver
		
		ConfigFileReader configFileReader = new ConfigFileReader();	
		
		System.setProperty(configFileReader.getDriverPropertyFirefox(),configFileReader.getDriverPathFirefox()); //Use double '\\' for escape sequence
		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com");  //Get the URL in the browser
		System.out.println(driver.getTitle());
		driver.close(); // Close the browser
		

	}

}
