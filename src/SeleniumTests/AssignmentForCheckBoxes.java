package SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;

public class AssignmentForCheckBoxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConfigFileReader configFileReader = new ConfigFileReader();

		System.setProperty(configFileReader.getDriverPropertyChrome(), configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		WebElement option = driver.findElement(By.id("checkBoxOption1"));
		option.click();

		Assert.assertTrue(option.isSelected());

		option.click();

		Assert.assertFalse(option.isSelected());

		// Method to give the count of the checkboxes present on the page

		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 3);

		driver.quit();
	}

}
