package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;

public class HandleDynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverPropertyChrome(),configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(5000); //Temporary Solution....Will be replaced by Implicit wait in further code
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='KQH']")).click();
		
		//Use Chropath extension in Chrome Browser
		//Wrap the Xpath in a separate round bracket and add an index to it
		//This should be used to handle dynamic dropdowns
		//driver.findElement(By.xpath("(//a[@value='AMD'])[2]")).click();
		
		//In case index is rejected, use Parent Xpath (space) Child Xpath
		
		Thread.sleep(5000); //Temporary Solution....Will be replaced by Implicit wait in further code
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='AMD']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		//driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))

		{

		System.out.println("its enabled");

		Assert.assertTrue(true);

		}

		else

		{

		Assert.assertTrue(false);

		}

	}

}
