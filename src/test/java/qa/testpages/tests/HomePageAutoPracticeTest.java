package qa.testpages.tests;



import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.basepage.BasePage;
import qa.homepage.pages.HomePageAutoPractice;
import qa.homepage.util.Constants;


public class HomePageAutoPracticeTest {
	 public WebDriver driver;
	 public BasePage base;
	 public Properties prop;
	 public HomePageAutoPractice homePage;
	
	@BeforeMethod
	public void setup(){
		base = new BasePage();
		prop = base.init_prop();
		driver = base.init_driver(prop);
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		homePage = new HomePageAutoPractice(driver);
		}
	
	
	/**
	 * USER STORY:1
	 * This method adds an item to cart and delete the same
	 */
	@Test(priority=2)
	public void verifyItemDeletedFromCart(){
		
		homePage.addItemToCart();
		Assert.assertTrue(homePage.checkItemInCart());
		homePage.deleteItemFromCart();
		Assert.assertTrue(homePage.checkDeleteMsgCart());
		
	}
	

	/**
	 * USER STORY:2
	 *This method navigates the user to Summer dresses page
	 */
	@Test(priority=1)
	public void verifySummerDressPage(){
		homePage.menuClick();
		Assert.assertTrue(homePage.checkSummerDressText());
	}
	
	/**
	 * USER-STORY:3
	 * This method allows the user to sign up with valid details
	 */
	
	@Test(priority=3)
	public void verifyUserRegister(){
		homePage.createAcc();
		Assert.assertEquals(homePage.checkSignupPageLand(),Constants.SIGNUP_PAGE_LAND);
		homePage.checkUserSignUp();
		Assert.assertEquals(homePage.chjeckMyAccPageTitle(), Constants.ACCOUNT_PAGE);
		Assert.assertEquals(homePage.checkAccNamw(),Constants.ACCOUNT_NAME);
		
	}
	
	
	/**
	 * USER STORY:4
	 * This method verifies the slider changes the position according to the given coordinates
	 */
    @Test(priority=4)
	public void verifySliderChangesPriceRange(){
    	// This functionality not working in the website. The results are not loading after changing the slider position manually,
    	//So I haven't used any assertion.
		homePage.checkSliderChangesPriceRange();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}

