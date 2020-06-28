package ajaxAndIframes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import dataProvider.ConfigFileReader;

public class Actionsdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigFileReader configFileReader = new ConfigFileReader();
		
		System.setProperty(configFileReader.getDriverPropertyChrome(),configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		//Use of actions class to hover over the Web Element
		//build() and perform() methods are mandatory for the action to be invoked
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		//Composite Action performed an object of using Actions class
		act.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		act.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).doubleClick().build().perform();		
		act.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).contextClick().build().perform();
		
		driver.quit();

	}

}
