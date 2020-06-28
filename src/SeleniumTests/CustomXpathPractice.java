package SeleniumTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;

public class CustomXpathPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*System.setProperty("webdriver.chrome.driver","D:\\MyJavaLearning\\Drivers\\chromedriver.exe"); //Use double '\\' for escape sequence
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");*/
		
		/*driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sudeshdeulkar95@outlook.com");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("sudeshd");
		driver.findElement(By.xpath("//input[@data-testid='royal_login_button']")).click();*/
		
		
		//Parent Child RelationShip Xpath
		
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverPropertyChrome(),configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		
		driver.findElement(By.xpath("//div[@class='RNNXgb']/div/div[2]/input")).sendKeys("Software Testing");
		

	}

}
