package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement userName;
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	@FindBy(xpath = "//button[text()='Sign In']")
	public WebElement signIn;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alert;

	public LoginPage enterUserNameOnUserNameField(String username) {
		userName.sendKeys(username);
		return this;
	}

	public LoginPage enterPasswordonPasswordField(String password1) {
		password.sendKeys(password1);
		return this;
	}

	public HomePage clickOnSignInButton() {

		signIn.click();
		return new HomePage(driver);
	}

	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
