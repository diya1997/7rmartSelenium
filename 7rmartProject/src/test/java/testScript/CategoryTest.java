package testScript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class CategoryTest extends Base {
	public HomePage homePage;
	public CategoryPage categoryPage;

	@Test(description = "Adding new Category",priority=1)
	public void addNewCategoryOnListCategories() throws IOException, InterruptedException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		String itemName = ExcelUtility.getStringData(1, 0, "CategoryPage");
		String image = Constants.TESTDATAFILE1;
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordonPasswordField(password1);
		homePage=login.clickOnSignInButton();
		categoryPage=homePage.clickCategory();
		categoryPage.clicktheNewButtonForAddingCategory().enterCategoryOnCategory(itemName).imageUpload(image);
		Boolean imagePreviewDisplayed=categoryPage.isImagePreviewDisplayed();
		Assert.assertTrue(imagePreviewDisplayed,Messages.IMAGEPREVIEWERROR);
		categoryPage.clickRadioButtonForShowOnTop().clickRadioButtonForShowOnLeft().saveNewCategoryItem();
		
	}

	@Test(retryAnalyzer=retry.Retry.class,description="Verify Search option",priority=2)
	public void checkSearchOptionIsWorking() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		String itemName = ExcelUtility.getStringData(1, 0, "CategoryPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordonPasswordField(password1);
		homePage=login.clickOnSignInButton();
		categoryPage=homePage.clickCategory();
		categoryPage.clickSearchButton().enterCategoryOnSearchField(itemName).clickSearchCategoryButton();
		Boolean pageNumberDisplayed=categoryPage.isPageNumberDisplayedAfterSearch();
		Assert.assertTrue(pageNumberDisplayed, Messages.NEWCATEGORYADDINGERROR);
		

	}
}
