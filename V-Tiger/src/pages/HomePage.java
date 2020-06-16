package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath="(//div[@class='row app-navigator'])[1]")
	private WebElement navigatorButton;
	
	@FindBy(xpath="//span[contains(text(), 'PROJECTS')]")
	private WebElement projects;
	
	@FindBy(xpath="//span[@title='Uma Admin(admin)']")
	private WebElement personIcon;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOut;
	
	@FindBy(className="keyword-input")
	private WebElement inputSearchTask;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setInput(String wrd) {
		inputSearchTask.sendKeys(wrd);
	}

   public void clickNavigator() {
	   navigatorButton.click();
   }
	
   public void clickProjects() {
	   projects.click();
   }
   
   public void clickPersonIcon() {
	   personIcon.click();
   }
   
   public void clickSignOut() {
	   signOut.click();
   }
}
