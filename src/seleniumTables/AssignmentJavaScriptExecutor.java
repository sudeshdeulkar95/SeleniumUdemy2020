package seleniumTables;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;

public class AssignmentJavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverPropertyChrome(),configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//United States (USA)
		driver.findElement(By.id("autocomplete")).sendKeys("Unit");
		
		Thread.sleep(2000);
		
		JavascriptExecutor code = (JavascriptExecutor) driver;
		String script = "return document.getElementById(\"autocomplete\").value;";
		String text=(String) code.executeScript(script);
		
		int i=0;
		while(!text.equalsIgnoreCase("United States (USA)")){
			i++;
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			text=(String) code.executeScript(script);

			if(i>10){
				System.out.println("The place does not exist");
				break;
			}
		}
		System.out.println(text);
		driver.quit();
	}

}
