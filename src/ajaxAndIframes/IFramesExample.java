package ajaxAndIframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import dataProvider.ConfigFileReader;

public class IFramesExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverPropertyChrome(),configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		WebElement myFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		//driver.findElements(By.tagName("iFrame")).size();
		//driver.switchTo().frame(0);
		
		driver.switchTo().frame(myFrame);
		
		// Use actions class for using Drag and Drop method
		Actions act = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		act.dragAndDrop(source, target).build().perform();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='droppable']/p")).getText(),"Dropped!");
		
		//Come out of frames which is a mandatory step to be performed
		driver.switchTo().defaultContent();
		
		driver.quit();

	}

}
