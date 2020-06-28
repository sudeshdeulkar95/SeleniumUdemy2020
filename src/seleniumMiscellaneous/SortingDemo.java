package seleniumMiscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;

public class SortingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverPropertyChrome(),configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		List<WebElement> fruitsElements = driver.findElements(By.xpath("//tr/td[2]"));
		
/*		System.out.println("************Original List************");
		
		for(int i=0;i<fruitsElements.size();i++){
			System.out.println(driver.findElements(By.xpath("//tr/td[2]")).get(i).getText());
		}*/
		
		driver.findElement(By.xpath("//tr/th[2]")).click(); //One Click for descending
		
		//Create a ArrayList of Strings and convert the List<WebElements> to ArrayList
		ArrayList<String> fruits = new ArrayList<String>();
		
		for(int i=0;i<fruitsElements.size();i++){
			fruits.add(fruitsElements.get(i).getText());
		}
		
		//Create a copy ArrayList of fruits for sorting it and comparing it with the original arraylist
		ArrayList<String> fruitsCopy = new ArrayList<String>();
		for(int i=0;i<fruits.size();i++){
			fruitsCopy.add(fruits.get(i));
		}
		
		Collections.sort(fruitsCopy);  //Collections framework is used for different operations on the collections such as Arraylist
		// .sort() method will sort the elements in the arraylist in ascending order by default
		Collections.reverse(fruitsCopy); // .reverse() method will sort the elements in the arraylist in descending order
		
		//Print the list with the help of enhanced for loop
		System.out.println("************Original List************");
		for(String s1:fruits){
			System.out.println(s1);
		}
		
		System.out.println("************Sorted List************");
		for(String s2:fruitsCopy){
			System.out.println(s2);
		}
		
		Assert.assertTrue(fruits.equals(fruitsCopy));
		
		driver.quit();
	}

}
