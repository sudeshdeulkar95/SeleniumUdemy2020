package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;


public class UpdatedUI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverProperty(),configFileReader.getDriverPath());
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(2000L);

		/*int i=1;

		while(i<5){
		driver.findElement(By.id("hrefIncAdt")).click();//4 times
		i++;
		}*/

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		for(int i=1;i<5;i++){
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
		//Code wont work with latest UI of SpiceJet.com

	}

}
