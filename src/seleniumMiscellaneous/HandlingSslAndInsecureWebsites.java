package seleniumMiscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandlingSslAndInsecureWebsites {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DesiredCapabilities dcp = DesiredCapabilities.chrome();
		//dcp.acceptInsecureCerts(); #1 way to accept insecure certs
		dcp.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dcp.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		//Set capability to handle the websites using SSL Certificates
		//Set capability to handle the insecure websites
		ChromeOptions ch = new ChromeOptions();
		ch.merge(dcp);
		
		System.setProperty("webdriver.chrome.driver","D:\\MyJavaLearning\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(ch);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
	}

}
