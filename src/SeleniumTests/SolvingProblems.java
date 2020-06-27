package SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import dataProvider.ConfigFileReader;

public class SolvingProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverProperty(),configFileReader.getDriverPath()); //Use double '\\' for escape sequence
		WebDriver driver = new ChromeDriver();
		driver.get("http://testing.todvachev.com/sitemap-posttype-post.xml");  //Get the URL in the browser
		System.out.println(driver.getTitle());
		System.out.println(driver.getPageSource());
	}

}
