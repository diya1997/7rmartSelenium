package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
	public HomePage homePage;
	public AdminUsersPage adminUsersPage;
	
	@Test(description="Adding new users")
	public void addingnewUsersonManageUsers() throws IOException
	{
	String username = ExcelUtility.getStringData(1, 0, "LoginPage");
	String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
	LoginPage login = new LoginPage(driver);
	login.enterUserNameOnUserNameField(username);
	login.enterPasswordonPasswordField(password1);
	homePage=login.clickOnSignInButton();
	FakerUtility faker=new FakerUtility();
	String username2=faker.createRandomUsername();
	String password2=faker.createRandomPassword();
	adminUsersPage=homePage.clickAdminUsers();
	adminUsersPage.clickManageUsers().clickNewButton().enterUserName(username2).enterPassword(password2).enterUserType().clickSaveButton();
	boolean alertDisplayed=adminUsersPage.isAlertDisplayed();
	Assert.assertTrue(alertDisplayed,Messages.NEWUSERADDINGERROR);
	}
}
