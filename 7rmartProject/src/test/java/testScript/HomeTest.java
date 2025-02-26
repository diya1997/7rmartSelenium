package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class HomeTest extends Base {

	public HomePage homePage;
	@Test(description="user can access Dashboard Menu on Home Pge",priority=1)
	public void accessOfDashboardMenuOnHomePage() throws IOException, InterruptedException
	{
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordonPasswordField(password1);
		homePage=login.clickOnSignInButton();
		homePage.clickDashboardMenu();
		Boolean cdcDisplayed=homePage.iscdcDisplayed();
		Assert.assertTrue(cdcDisplayed,Messages.DASHBOARDACESSERROR);
	}

	@Test(description = "Perform logout by Admin",priority=2)
	public void logOutByAdmin() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordonPasswordField(password1);
		homePage=login.clickOnSignInButton();
		homePage.verifylogoutByAdmin();
		String actual = driver.getTitle();
		String expected = "Login | 7rmart supermarket";
		Assert.assertEquals(actual, expected,Messages.LOGOUTERRORBYADMIN);

	}
}
