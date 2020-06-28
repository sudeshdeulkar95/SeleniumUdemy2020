package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	 private Properties properties;
	 private final String propertyFilePath= "configs//Configuration.properties";
	 
	 
	 public ConfigFileReader(){
	 BufferedReader reader;
	 try {
	 reader = new BufferedReader(new FileReader(propertyFilePath));
	 properties = new Properties();
	 try {
	 properties.load(reader);
	 reader.close();
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 } catch (FileNotFoundException e) {
	 e.printStackTrace();
	 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	 } 
	 }
	 
	 public String getDriverPathChrome(){
	 String driverPathChrome = properties.getProperty("driverPathChrome");
	 if(driverPathChrome!= null) return driverPathChrome;
	 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
	 }
	 
	 public String getDriverPropertyChrome(){
	 String driverPropertyChrome = properties.getProperty("driverPropertyChrome");
	 if(driverPropertyChrome!= null) return driverPropertyChrome;
	 else throw new RuntimeException("driverProperty not specified in the Configuration.properties file."); 
	 }
	 
	 public String getDriverPathFirefox(){
	 String driverPathFirefox = properties.getProperty("driverPathFirefox");
	 if(driverPathFirefox!= null) return driverPathFirefox;
	 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
	 }
	 
	 public String getDriverPropertyFirefox(){
	 String driverPropertyFirefox = properties.getProperty("driverPropertyFirefox");
	 if(driverPropertyFirefox!= null) return driverPropertyFirefox;
	 else throw new RuntimeException("driverProperty not specified in the Configuration.properties file."); 
	 }

}
