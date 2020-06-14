package realTimeSeleniumExamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CalendarRealTime {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
				
		System.setProperty("webdriver.chrome.driver","D:\\MyJavaLearning\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();
		
		//Click on Next until February month arrives for which negation is added in the condition
		while(!driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']")).getText().contains("February")){
			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']")).click();
		}
		
		//Grab the common element for all the dates 
		List<WebElement> days = driver.findElements(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td"));
		
		//Get the size
		int count = days.size();
		
		//Iterate through the each and every date element to get the exact date
		for(int i=0;i<count;i++){
			String text = driver.findElements(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td")).get(i).getText();
			if(text.equals("15")){
				driver.findElements(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td")).get(i).click();
				break;
			}
		}	
	}
}
