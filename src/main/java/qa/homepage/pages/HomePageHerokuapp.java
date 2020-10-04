package qa.homepage.pages;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.homepage.util.ElementUtil;

public class HomePageHerokuapp {
	public WebDriver driver;
	public ElementUtil elementUtil;
// By locators	
	By formAuth= By.linkText("Form Authentication");
	By username = By.id("username");
	By password = By.id("password");
	By login = By.cssSelector("button.radius");
	By loginError = By.cssSelector("div.error");
	By loggedInCheck = By.xpath("//div[@class='flash success']");
	By logout = By.cssSelector("a.button");
	
	By scroll = By.linkText("Infinite Scroll");
	By scrollText = By.xpath("//div[@class]/h3");
		
	By keyPress = By.linkText("Key Presses");
	By keyInput = By.xpath("//input[@id='target']");
	By keysText = By.xpath("//p[@id='result']");
	
	public HomePageHerokuapp(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
	}
	
	// Page actions
	public boolean checkLoggedInMsg(){
		return elementUtil.getElement(loggedInCheck).isDisplayed();
	}
	
	public boolean checkErrorLogin(){
		return elementUtil.getElement(loginError).isDisplayed();
	}
	 
	public void dologin (String un, String pwd){
		elementUtil.doClick(formAuth);
		elementUtil.doSendKeys(this.username, un);
		elementUtil.doSendKeys(this.password,pwd);
		elementUtil.doClick(login);
		elementUtil.doClick(logout);
		
	}
	
	
	
	public void checkScrollPageDown() throws InterruptedException {
		elementUtil.doClick(scroll);
		 Thread.sleep(3000);
		 JavascriptExecutor js = ((JavascriptExecutor) driver);
         js.executeScript("window.scroll(0,2000)");
		Thread.sleep(3000);
         js.executeScript("window.scroll(0,2000)");
		 Thread.sleep(3000);
		 js.executeScript("window.scroll(0,-2000)");
	}	
	
	public String checkScrollText(){
		return elementUtil.doGetText(scrollText);
		
	}
	


	public void checkKeypress(String text){
		elementUtil.doClick(keyPress);
		Actions action = new Actions(driver);
		action.sendKeys(text).build().perform();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(elementUtil.getElement(keysText)));
		System.out.println();
		
		}
	
	public boolean checkKeyPressText(){
		return elementUtil.getElement(keysText).isDisplayed();
		}
}
