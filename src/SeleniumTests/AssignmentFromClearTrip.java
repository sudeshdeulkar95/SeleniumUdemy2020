package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import dataProvider.ConfigFileReader;

public class AssignmentFromClearTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options=new ChromeOptions();

		options.addArguments("--disable-notifications"); //the code is to disable notifications (got from reviewing code)
		
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverPropertyChrome(),configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();

		//Click on current date on the calendar
		driver.findElement(By.xpath("//input[@id='DepartDate']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();
		
		Thread.sleep(2000);
		
		//Click on the dropdown for selecting the number for adult passengers
		Select adults = new Select(driver.findElement(By.xpath("//select[@id='Adults']")));
		adults.selectByIndex(7);
		
		Thread.sleep(2000);
		
		//Click on the dropdown for selecting the number for children passengers
		Select childrens = new Select(driver.findElement(By.xpath("//select[@id='Childrens']")));
		childrens.selectByIndex(1);
		
		Thread.sleep(2000);
		
		//Click on the dropdown for selecting the number for infant passengers
		Select infants = new Select(driver.findElement(By.xpath("//select[@id='Infants']")));
		infants.selectByIndex(4);
		
		//Click on More Options Link
		driver.findElement(By.xpath("//a[@id='MoreOptionsLink']")).click();
		
		Thread.sleep(2000);
		
		//Click on the dropdown for selecting the class of travel
		Select flightClass = new Select(driver.findElement(By.xpath("//select[@id='Class']")));
		flightClass.selectByVisibleText("Premium Economy");
		
		Thread.sleep(2000);
		
		//Write the preffered airline chain
		driver.findElement(By.xpath("//input[@id='AirlineAutocomplete']")).sendKeys("Indigo");
		
		Thread.sleep(2000);
		
		//Click on the Search Flights Button
		driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
		
		Thread.sleep(2000);
		
		//Get the error message from the Screen
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
