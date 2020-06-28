package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;

public class HandleJavaAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String text = "Sudesh";
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverPropertyChrome(),configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//Handle Alert containing OK button
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(text);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		//Switch to the JavaScript Alert which is not accessible by the Selenium Code
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept(); //Accept will click on OK button
		
		//Handle Alert containing Cancel button
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(text);
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		
		//Switch to the JavaScript Alert which is not accessible by the Selenium Code
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss(); //Accept will click on Cancel button
		
		Thread.sleep(5000);
		
		driver.quit();	
	}

}
