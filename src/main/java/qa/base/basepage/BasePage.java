package qa.base.basepage;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(Properties prop){
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver() ;

		} 
		else if (browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		else {
			System.out.println("Please check and provide the right browser");
		}
		
	    driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		return driver;
	}		
	
	public Properties init_prop(){
		
		 prop = new Properties();
		 
		 
		 String path = "C:/JavaSelenium/AnswerDigitalAutomation/src/main/java/qa/homepage/config/config.properties";
		
		 try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("Path not found..please correct your config");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;	
}

}

