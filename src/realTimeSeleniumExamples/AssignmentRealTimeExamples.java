package realTimeSeleniumExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import dataProvider.ConfigFileReader;

public class AssignmentRealTimeExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverProperty(),configFileReader.getDriverPath());
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();
		String myOption = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
		
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		
		Select myDropdown = new Select(dropDown);
		
		myDropdown.selectByVisibleText(myOption);
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(myOption);
		
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		Assert.assertTrue(driver.switchTo().alert().getText().contains(myOption));
		
		System.out.println(driver.switchTo().alert().getText());
		
		driver.quit();
	}
}
