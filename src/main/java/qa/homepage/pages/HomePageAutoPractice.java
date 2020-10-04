package qa.homepage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import qa.base.basepage.BasePage;
import qa.homepage.util.Constants;
import qa.homepage.util.ElementUtil;

public class HomePageAutoPractice extends BasePage {
	private WebDriver driver;
	ElementUtil elementUtil;
	
	/*
	 * By Locators
	 */
	
	By item = By.xpath("(//img[@class='replace-2x img-responsive' and @ title='Printed Dress'])[2]");
	 By itemClick = By.xpath("//button[@class='exclusive']");
	 By close = By.cssSelector("span.cross");
	 By clickCart = By.cssSelector("div.shopping_cart");
	 By deleteItem = By.cssSelector("i.icon-trash");
	 By checkMsg = By.xpath("//span[@class='navigation_page']");
	 By checkItemAddedText = By.xpath("//span[contains(text(),'There is 1 item in your cart.')]");
	 By deleteMessage = By.cssSelector("p.alert-warning");
	 
	 
	 By clickWomen = By.cssSelector("a.sf-with-ul");
	 By clickSummerDress = By.linkText("Summer Dresses");
	 By SummerDressText = By.xpath("//span[@class='cat-name']");
	 
	 
	 By signin = By.className("login");
	 By emailCreate = By.id("email_create");
	 By submitCreate = By.id("SubmitCreate");
	 By signupPageLand = By.cssSelector("span.navigation_page");
	 
	 
	 By firstName = By.id("customer_firstname");
	 By lastName = By.id("customer_lastname");
	 By email = By.id("email");
	 By password = By.id("passwd");
	 
	 By fn = By.xpath("//input[@id='firstname']");
	 By ln = By.xpath("//input[@id='lastname']");
	 By address = By.id("address1");
	 By city = By.id("city");
	 By state = By.id("id_state");
	 By postCode = By.id("postcode");
	 By country = By.id("id_country");
	 By mobilePhone = By.id("phone_mobile");
	 By addressAlias = By.id("alias");
	 By register = By.id("submitAccount");
	 By accName = By.xpath("//a[@class='account']/span");
	 
	 
	 By slider = By.xpath("(//a[@href='#'])[2]");
	 
	 
	 
	public HomePageAutoPractice(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
	}
	public boolean checkItemInCart(){
		return elementUtil.getElement(checkMsg).isDisplayed();
			
	}
	
	public boolean checkDeleteMsgCart(){
		return elementUtil.getElement(deleteMessage).isDisplayed();
			
	}
	
	public void addItemToCart(){
		
		elementUtil.doClick(item);
		System.out.println("Item clicked by user");
		elementUtil.doClick(itemClick);
		elementUtil.doClick(clickCart);		
	
		
		
	}
	
	public void deleteItemFromCart(){
		
		elementUtil.doClick(deleteItem);
		System.out.println("item cancelled");
		}
		
	
	public void menuClick(){
		Actions action = new Actions(driver);
		action.moveToElement(elementUtil.getElement(clickWomen)).build().perform();
		elementUtil.doClick(clickSummerDress);
		
	}
	
	public boolean checkSummerDressText(){
		
		return elementUtil.getElement(SummerDressText).isDisplayed();
	}
		
	
	public void createAcc(){
		elementUtil.doClick(signin);
		elementUtil.doSendKeys(emailCreate, Constants.CREATE_EMAIL);
		elementUtil.doClick(submitCreate);
	}
	
	
	public String checkSignupPageLand(){
		return elementUtil.doGetText(signupPageLand);
	}
	
	public void checkUserSignUp(){
		
		elementUtil.doSendKeys(firstName, "Jhon");
		elementUtil.doSendKeys(lastName, "Samuel");
		elementUtil.doSendKeys(email, Constants.CREATE_EMAIL);
		elementUtil.doSendKeys(password, "98u75");
		elementUtil.doSendKeys(fn, "Jhon");
		elementUtil.doSendKeys(ln, "Samuel");
		elementUtil.doSendKeys(address, "12B,northrise");
		elementUtil.doSendKeys(city, "Leeds");
		elementUtil.selectValueFromDropDown(elementUtil.getElement(state), "Georgia");
		elementUtil.doSendKeys(postCode, "00000");
		elementUtil.doSendKeys(mobilePhone, "7665437886");
		elementUtil.doSendKeys(addressAlias, "18,Greenroad");
		elementUtil.doClick(register);
		}
	
    public String checkAccNamw(){
    	return elementUtil.doGetText(accName);
    }
	
	public String chjeckMyAccPageTitle(){
		return elementUtil.doGetPageTitle();
	}
	
	
	
	
	public void checkSliderChangesPriceRange(){
		menuClick();
		WebElement slide = elementUtil.getElement(slider);
		Actions action = new Actions(driver);
		action.dragAndDropBy(slide, -140, 0).build().perform();
		
	}

}

