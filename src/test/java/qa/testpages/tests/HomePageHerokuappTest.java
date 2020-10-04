package qa.testpages.tests;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.base.basepage.BasePage;
import qa.homepage.pages.HomePageHerokuapp;
import qa.homepage.util.Constants;

public class HomePageHerokuappTest {
	
	 public WebDriver driver;
	 public BasePage base;
	 public Properties prop;
	 public HomePageHerokuapp homePage;
	 
	@BeforeMethod
	public void setup(){
		base = new BasePage();
		prop = base.init_prop();
		driver = base.init_driver(prop);
		driver.get(prop.getProperty("url1"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage = new HomePageHerokuapp(driver);
	}
	 
	
	@DataProvider
	public Object[][] getInvalidLoginDetails() {
	    Object data[][]={{"tomsmith", "asfdghh"},
	    		{"dsfgghhjj@", "SuperSecretPassword!"}
	    };
	    return data;
	}	
	
	
	/**
	 * This method gets invalid input data from data provider and verifies login function
	 * @param un
	 * @param pwd
	 */
	@Test(priority=1, dataProvider="getInvalidLoginDetails")
	public void verifyInvalidLogin(String un, String pwd) {
		
		homePage.dologin(un,pwd);
		Assert.assertTrue(homePage.checkErrorLogin());
	}
	
	
	/**
	 * This method verifies login functionality for valid input
	 */
	@Test(priority=2)
	public void verifyValidLogin(){
		homePage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.checkLoggedInMsg());
	}
	
	
	/**
	 * This method is user to verify page scroll
	 * @throws InterruptedException
	 */
	@Test(priority=3)
	public void verifyPageScroll() throws InterruptedException{
		homePage.checkScrollPageDown();
		Assert.assertEquals(homePage.checkScrollText(),Constants.SCROLL_PAGE_TEXT);
	}
	
	
	@DataProvider
	public Object[][] keyPressDetails() {
	    Object data[][]={{"Keys.CLEAR"},
	    		{"Keys.NUMPAD7"},
	    		{"Keys.SPACE"},
	    		{"Keys.NUMPAD8"}
	    };
	    return data;
	}	
	
	/**
	 * This method is used to get the key press info
	 * @param keytxt
	 */
	@Test(priority=4,dataProvider="keyPressDetails")
	public void verifyKeyPress(String keytxt){
		homePage.checkKeypress(keytxt);
		Assert.assertTrue(homePage.checkKeyPressText());
		
		}
	

	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}	
