package SeleniumTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;

public class NewWebsiteCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverProperty(),configFileReader.getDriverPath()); //Use double '\\' for escape sequence
		WebDriver driver = new ChromeDriver();
		driver.get("https://rediff.com");
		  
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click(); //Regular Expression for CSS 
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("hello");
		driver.findElement(By.cssSelector("input#password")).sendKeys("goodbye"); //Regular Expression for CSS
		driver.findElement(By.xpath("//input[contains(@name,'procee')]")).click(); // Regular Expression for Xpath
		
		//Try this code on another machine as Rediff.com was not available on Cybage machine
		
		
		

	}

}
