package ajaxAndIframes;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlingmultiplewindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\MyJavaLearning\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://phptravels.com/order");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[contains(text(),'Support')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Product Docs')]")).click();
		
		System.out.println(driver.getTitle());
		
		//Set is used to get the ids for the window handles
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(parentId);
		
		System.out.println(driver.getTitle());

	}

}
