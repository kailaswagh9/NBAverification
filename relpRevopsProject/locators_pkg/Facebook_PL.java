package locators_pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common_Functions_Web.WebWait;

public class Facebook_PL {

	WebDriver driver = null;
	public Facebook_PL(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(id="email")
	private WebElement username;
	public WebElement getUsername() {
		return username;
	}
	@FindBy(id="pass")
	private WebElement password;
	public WebElement getPassword() {
		return password;
	}
	@FindBy(name="login")
	private WebElement fbLoginBtn;
	public WebElement getFbLoginButton() {
		return fbLoginBtn;
	}
	@FindBy(xpath="//input[@type='search' and @placeholder='Search Facebook']")
	private WebElement fbSearchBtn;
	public WebElement getFbSearchBtn() {
		return WebWait.elementToBeClickable(driver, fbSearchBtn);
	}

}
