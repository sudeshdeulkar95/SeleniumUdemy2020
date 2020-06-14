package seleniumMiscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizingWindowsAndDeletingCookies {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:\\MyJavaLearning\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize(); //Maximize the window
		driver.manage().deleteAllCookies(); //Deletes all the cookies so that no autopopup should be generated
		//driver.manage().deleteCookieNamed("<String>"); //Delete a specific cookie takes string input
	}

}
