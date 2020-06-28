/*Problem Statement
 * Go to the website https://rahulshettyacademy.com/seleniumPractise
 * Click on Add to cart
 * Add multiple items into the cart.
 * */

/*Learnings
 * If you need to click a particular element within the list of WebElements, use the method get(index).click()
 * If you need to get the text of a particular element within the list of WebElements, use the method get(index).getText()
 * Use the method split() in array of string to split the characters based upon the character provided in the method
 * Use the method trim() in string to trim the extra spaces in the word
 * Use Arrays.asList() method to convert the Arrays to ArrayList which supports more methods to manipulate the arrays
 * Do not use Text of the WebElement in the Xpath as the text may change in runtime
 * */

package seleniumFunctionalTesting;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;

public class Additemsintocart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverPropertyChrome(),configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise"); //Vegetable website
		driver.manage().window().maximize(); 
		
		Thread.sleep(5000); // Wait for the website to load

		String[] vegetables = {"Cauliflower","Tomato","Beans"};
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
		
		Thread.sleep(5000);
		driver.quit();
	}
}
