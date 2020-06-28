package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;

public class HandleAutoSuggestDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverPropertyChrome(),configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(4000); 
		
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		
		WebElement source = driver.findElement(By.xpath("//input[@placeholder='From']"));
		
		source.sendKeys("MUM");
		
		Thread.sleep(4000);
		
		source.sendKeys(Keys.ARROW_DOWN);
		
		Thread.sleep(4000);
		
		source.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//label[@for='toCity']")).click();
		
		WebElement destination = driver.findElement(By.xpath("//input[@placeholder='To']"));
		
		destination.sendKeys("DEL");
		
		for(int i=1;i<4;i++)
		destination.sendKeys(Keys.ARROW_DOWN);
		
		Thread.sleep(4000);
		
		destination.sendKeys(Keys.ENTER);
		
		Thread.sleep(4000);
		
		driver.quit();
		
		
		//input[@placeholder='To']
		//input[@placeholder='From']

	}

}
