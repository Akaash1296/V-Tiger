package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name="username")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement pwrd;
	
	@FindBy(className="forgotPasswordLink")
    private WebElement forgotPassword;
	@FindBy(xpath="//button[@type='submit']")
    private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un) {
		userName.clear();
		userName.sendKeys(un);
	}
	
	public void setPassword(String pwd) {
		pwrd.clear();
		pwrd.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	public void clickForgotPassword() {
		forgotPassword.click();
	}
}
