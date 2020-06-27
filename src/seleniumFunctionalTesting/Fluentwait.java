/*Learnings
 * Implementation of Fluent Wait
 * Polling until the Web Element is located
 * */

package seleniumFunctionalTesting;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import dataProvider.ConfigFileReader;

public class Fluentwait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverProperty(),configFileReader.getDriverPath());
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		
		//Implement the Wait Interface for the Fluent Wait
		//Polling conducted every 5 seconds till 30 seconds max
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
	   //Implement the method to wait the element is located
	   WebElement helloWorld = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       if(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed())
			   		return driver.findElement(By.xpath("//div[@id='finish']/h4"));
			       else
			    	return null;
			     }
	   });
	   System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());
	   driver.quit();
			   
	}

}
