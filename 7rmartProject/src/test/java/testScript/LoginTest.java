package testScript;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class LoginTest extends Base {
	public HomePage homePage;
	@Test(description = "Login using valid credentials", priority = 1,groups = {"smoke"})
	public void userLoginWithValidUsernameAndPassword() throws IOException {
		
		String username=ExcelUtility.getStringData(1, 0,"LoginPage");
		String password1=ExcelUtility.getStringData(1, 1,"LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordonPasswordField(password1);
		homePage=login.clickOnSignInButton();
		boolean isDashboardDisplayed=login.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.VALIDCREDENTIALERROR);
	}

	@Test(description = "Login using invalid credentials", priority = 2,dataProvider="loginProvider")
	public void userLoginWithInvalidUsernameAndInvalidPassword(String username,String password1) throws IOException {
		//String username=ExcelUtility.getStringData(2, 0,"LoginPage");
		//String password1=ExcelUtility.getStringData(2, 1,"LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordonPasswordField(password1);
		homePage=login.clickOnSignInButton();
		boolean isAlertDisplayed=login.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,Messages.INVALIDCREDENTIALLOGIN);
		
	}

	@Test(description = "Login using invalid username", priority = 3,groups = {"smoke"})
	public void userLoginWithInvalidUsernameAndvalidPassword() throws IOException {
		String username=ExcelUtility.getStringData(4, 0,"LoginPage");
		String password1=ExcelUtility.getStringData(4, 1,"LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordonPasswordField(password1);
		homePage=login.clickOnSignInButton();
		boolean isAlertDisplayed=login.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Messages.INVALIDUSERNAMELOGIN);
	}

	@Test(description = "Login using invalid password", priority = 4)
	public void userLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String username=ExcelUtility.getStringData(3, 0,"LoginPage");
		String password1=ExcelUtility.getStringData(3, 1,"LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordonPasswordField(password1);
		homePage=login.clickOnSignInButton();
		boolean isAlertDisplayed=login.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Messages.INVALIDPASSWORDLOGIN);
	}
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] {
			new Object[] {"admin123","123"},
			new Object[] {ExcelUtility.getStringData(4,0,"LoginPage"),ExcelUtility.getStringData(4,1,"LoginPage")}
		};
	}
}
