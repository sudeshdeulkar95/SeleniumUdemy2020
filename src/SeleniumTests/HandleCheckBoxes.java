package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//Import TestNG Jars by downloading from Internet
//TestNG is a test framework
// Use Assert to validate the responses

public class HandleCheckBoxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\MyJavaLearning\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.cssSelector("input[id*='friendsandfamily']")); // Match the type in CSS Selector
		
		//System.out.println(element.isSelected()); //Returns true or false
		
		Assert.assertFalse(element.isSelected());
		
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		
		//System.out.println(element.isSelected());
		
		Assert.assertTrue(element.isSelected());
		
		//Count the number of checkboxes
		
		//System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size()); //size() gives the count of elements and findElements is used for identifying multiple web elements
		
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);
		
		//driver.quit();
		
		
	}

}
