package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleStaticDropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\MyJavaLearning\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		//Select class is used to handle the static dropdowns
		//It can be used only if the select tag is present for the dropdown
		Select sel = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		//sel.selectByValue("AMD");
		//sel.selectByIndex(3); //Index starts from 0
		//sel.selectByVisibleText("Amritsar (ATQ)");
		
		//Does not work with latest spicejet website as the UI has changed
		
		//sel.selectByValue("INR");
		Thread.sleep(2000);
		sel.selectByIndex(2);
		Thread.sleep(2000);
		sel.selectByVisibleText("AED");
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).getText());
		
		driver.quit();

	}

}
