package qa.homepage.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class ElementUtil {
	
	WebDriver driver;
	
	public ElementUtil(WebDriver driver){
		this.driver= driver;
	}
	
	
	/**
	 * This method is used to create the web element on the basis of locator
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator){
		WebElement element = null;
		try{
		element = driver.findElement(locator);
		System.out.println("WebElement is created successfully : " +locator);
		} catch(Exception e){
			System.out.println("Some exception occured while creating the element");
		}
		return element;
	}
	
	/**
	 * This method is used to get the text of the web element
	 * @param locator
	 * @return
	 */
	public String doGetText(By locator){
		try{
		return getElement(locator).getText();
		}catch (Exception e){
			System.out.println("Some exception occured while getting the text from the web element");		
		}
		return null;
	}
	
	/**
	 * This method is used to pass values to the web element
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator,String value){
		try{
			WebElement ele = getElement(locator);
			 ele.clear();
			 ele.sendKeys(value);
		}catch(Exception e){
			System.out.println("Some exception occured while sending value to the web element");
		}
		 
	}
	
	
	/**
	 * This method is used to click on the web element
	 * @param locator
	 */
	 public void doClick(By locator){
		try{
			getElement(locator).click();	
		} catch(Exception e){
			
		}
	}
	 
	 /**
	  * This method is used to send value to the web element using Actions class
	  * @param locator
	  * @param value
	  */
	 public void doActionsSendKeys(By locator , String value){
			try{
			Actions action = new Actions(driver);
			WebElement element = getElement(locator);
			action.sendKeys(element,value).build().perform();;
			} catch(Exception e){
				System.out.println("Some exception occured while sending value to the web element");
			}
		}
	 
	 /**
	  * This method is used to get the title of the page
	  * @return
	  */
	 public String doGetPageTitle(){
			try{
				return driver.getTitle();
			} catch(Exception e){
				System.out.println("Some exception occured while getting the page title");	
			}
			return null;
		}
	
	/**
	 * This method is used to select value from the drop down on the basis of given text
	 * @param element
	 * @param value
	 */
	public void selectValueFromDropDown( WebElement element , String value){
			
			Select select = new Select(element);
			select.selectByVisibleText(value);
			
		}
}
