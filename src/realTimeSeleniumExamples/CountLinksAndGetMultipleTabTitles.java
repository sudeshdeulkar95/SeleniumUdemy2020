/*Requirement
 * 1) Count the number of links in the page
 * 2) Count the number of links in the footer section by limiting the scope of driver
 * 3) Count the number of links in the particular column by limiting the scope of the driver
 * 4) Click on all the column links and open in new tab and get the tab name for each and every opened tab
 * */

package realTimeSeleniumExamples;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;

public class CountLinksAndGetMultipleTabTitles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigFileReader configFileReader = new ConfigFileReader();		
		
		System.setProperty(configFileReader.getDriverPropertyChrome(),configFileReader.getDriverPathChrome());
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//Get the number of links on the entire page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footerDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		
		//Get the number of links on the footer page
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		WebElement columnFooterDriver = footerDriver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
		
		//Get the number of links on the column footer page
		System.out.println(columnFooterDriver.findElements(By.tagName("a")).size());
		
		//Click on each and every link and open in new tab
		//Started from i=1 as the first link does not work
		for(int i=1;i<columnFooterDriver.findElements(By.tagName("a")).size();i++){
			String ctrlAndEnter = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnFooterDriver.findElements(By.tagName("a")).get(i).sendKeys(ctrlAndEnter);
		}
		
		//Get the Titles from each and every tab
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		
		//Switch to the different windows and get the titles
		while(it.hasNext()){
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		driver.quit();
		
	}

}
