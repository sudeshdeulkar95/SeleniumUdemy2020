/*Learnings
 * Static call to the method i.e Without creating an object of the class in Java
 * Non Static call to the method, need to remove the static keyword from the method in Java
 * Use Text of the Web Element only when it is not dynamic
 * Implicit wait will apply to each and every line
 * Explicit wait will apply to the locators which need the wait condition
 * */

package seleniumFunctionalTesting;

import java.util.Arrays;
import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Useofdifferentwaits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\MyJavaLearning\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Implicit Wait
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise"); //Vegetable website
		driver.manage().window().maximize();

		String[] vegetables = {"Cauliflower","Tomato","Beans"};
		
		addVegetablesToCart(driver,vegetables); //Static call to the method i.e Without creating an object of the class
		
		/*
		 Useofdifferentwaits addveg = new Useofdifferentwaits();
		 addveg.addVegetablesToCart(driver,vegetables);  // Non Static call to the method, need to remove the static keyword from the method
		*/
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click(); //Using button text as it is not dynamic text like 'Add to Cart' and the class name is blank
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter promo code']")));
		
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		//System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).isDisplayed());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='promoInfo']")).isDisplayed());
		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();

		driver.quit();
	}
	
	public static void addVegetablesToCart(WebDriver driver, String[] vegetables){
		int j=0;
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		for(int i=0;i<products.size();i++){
			String[] name = products.get(i).getText().split("-"); //Split method is used for arrays
			/* Split method will split the word into 2 separate words divided by the character mentioned in the method*/
			String itemName = name[0].trim(); //Trim method will remove all the blank spaces present in the string
			
			List<String> itemsNeeded = Arrays.asList(vegetables); //This method is used to convert the array to array list
			/*It is converted to use the .contains method which is not possible in Arrays*/
			
			if(itemsNeeded.contains(itemName)){
				j++; //Increment the count from the array of vegetables
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==vegetables.length)
					break;
			}
		}
	}
}
	


