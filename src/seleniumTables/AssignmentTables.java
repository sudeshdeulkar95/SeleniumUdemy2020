package seleniumTables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","D:\\MyJavaLearning\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebElement tableDriver = driver.findElement(By.xpath("//table[@name='courses']"));
		int rowCount = tableDriver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size();
		int columnCount = tableDriver.findElements(By.xpath("//table[@name='courses']/tbody//th")).size();
		System.out.println(rowCount);
		System.out.println(columnCount);
		
		List<WebElement> secondRow = tableDriver.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		
		System.out.println(secondRow.get(0).getText());

		System.out.println(secondRow.get(1).getText());

		System.out.println(secondRow.get(2).getText());
		
		driver.quit();	
	}

}
