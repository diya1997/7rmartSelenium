package testScript;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	public HomePage homePage;
	public SubCategoryPage subCategoryPage;

	@Test(description="Verifying Reset Option ",priority=1)
public void resetTheSubCategoryPage() throws IOException
{
	String username = ExcelUtility.getStringData(1, 0, "LoginPage");
	String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
	LoginPage login = new LoginPage(driver);
	login.enterUserNameOnUserNameField(username);
	login.enterPasswordonPasswordField(password1);
	homePage=login.clickOnSignInButton();
	subCategoryPage=homePage.clickSubCategory();
	subCategoryPage.clickResetButton();
	String actual=driver.getTitle();
	String expected="List Sub Categories | 7rmart supermarket";
	Assert.assertEquals(actual, expected,Messages.RESETERROR);
}
	@Test(description="Creation of new Sub Category",priority=2)
	public void addNewSubCategoryItem() throws IOException
	{
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		String itemName = ExcelUtility.getStringData(1, 0, "CategoryPage");
		String image = Constants.TESTDATAFILE1;
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordonPasswordField(password1);
		homePage=login.clickOnSignInButton();
		subCategoryPage=homePage.clickSubCategory();
		subCategoryPage.clickNewButton().selectCategoryOnCategoryField().enterTheSubCategory(itemName).imageUpload(image).clickSaveButton();
		boolean isAlertDisplayed=login.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Messages.NEWSUBCATEGORYADDINGERROR);
	}
}
