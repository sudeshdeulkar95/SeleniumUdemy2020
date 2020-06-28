package ajaxAndIframes;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;

public class AssignmentHandlingMultipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverPropertyChrome(),configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		
		driver.switchTo().window(parentId);
		
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		
		driver.quit();
		

	}

}
