package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	public HomePage homePage;
	public ManageNewsPage manageNewsPage;
	@Test(description="Adding new news")
	public void addingNewNewsOnMangeNews() throws IOException
	{
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		String news = ExcelUtility.getStringData(1, 0, "ManageNewsPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordonPasswordField(password1);
		homePage=login.clickOnSignInButton();
		manageNewsPage=homePage.clickManageNews();
		manageNewsPage.clickNewButton().enterTheNews(news).clickSaveButton();
		Boolean alertDisplayed=manageNewsPage.isAlertDisplayed();
		Assert.assertTrue(alertDisplayed, Messages.NEWNEWSADDINGERROR);
	}

}
