package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import dataProvider.ConfigFileReader;

public class E2ESpiceJetBookFlight {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Chrome Driver Location
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverPropertyChrome(),configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize(); //Maximize the window for better view
		
		Thread.sleep(5000);
		
		//Click on One Way Trip
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).click();
		
		Thread.sleep(2000);
		
		//Select the type of Customer
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		
		Thread.sleep(2000);
		
		//Select the Source
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='KQH']")).click();
		
		//Select the Destination
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='AMD']")).click();
		
		//Select the today's date for travel
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		//Check if the return date is enabled...If enabled then fail the test
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
			System.out.println("its disabled");
			Assert.assertTrue(true);
		}
		else{
			Assert.assertTrue(false);
		}
		
		//Select the number of passengers
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Thread.sleep(2000);
		Select adultPassengers = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		adultPassengers.selectByIndex(5);
		
		//Select the currency
		Select currency = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		currency.selectByValue("USD");
		
		//Find the flights
		driver.findElement(By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']")).click();
		
		Thread.sleep(20000);
		
		driver.quit();

	}

}
