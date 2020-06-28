package seleniumTables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;

public class JavaScriptDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverPropertyChrome(),configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("fromPlaceName")).sendKeys("BANG");
		
		JavascriptExecutor code = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
		
		String script = "return document.getElementById(\"fromPlaceName\").value;";
		String text=(String) code.executeScript(script);
		
		int i=0;
		while(!text.equalsIgnoreCase("BANGALORE INTERNATION AIRPORT")){
			i++;
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
			text=(String) code.executeScript(script);
			
		
			if(i>10){
				System.out.println("The place does not exist");
				break;
			}
		}
		System.out.println(text);
		driver.quit();
	}
}
