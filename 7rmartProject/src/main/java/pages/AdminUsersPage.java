package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
	public WebDriver driver;
	public int index=3;
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	//@FindBy(xpath="//i[@class='nav-icon fas fa-users']") public WebElement adminUsers;
	@FindBy(xpath="//p[text()='Manage Users']") public WebElement manageUsers;
	@FindBy(xpath="//a[@onclick='click_button(1)']") public WebElement newButton;
	@FindBy(xpath="//input[@id='username']") public WebElement userName;
	@FindBy(xpath="//input[@id='password']") public WebElement password;
	@FindBy(xpath="//select[@id='user_type']")public WebElement userType;
	@FindBy(xpath="//button[@name='Create']") public WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") public WebElement alert;
	
	public AdminUsersPage clickManageUsers()
	{
		manageUsers.click();
		return this;
	}
	public AdminUsersPage clickNewButton()
	{
		newButton.click();
		return this;
	}
	public AdminUsersPage enterUserName(String username2)
	{
		userName.sendKeys(username2);
		return this;
	}
	public AdminUsersPage enterPassword(String password2)
	{
		password.sendKeys(password2);
		return this;
	}
	public AdminUsersPage enterUserType()
	{
		Select select=new Select(userType);
		select.selectByIndex(2);
		return this;
	}
	public AdminUsersPage clickSaveButton()
	{
		saveButton.click();
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
