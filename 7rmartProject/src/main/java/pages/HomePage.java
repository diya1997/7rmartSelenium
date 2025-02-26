package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	WaitUtility wait=new WaitUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="//i[@class='nav-icon fas fa-users']") public WebElement adminUsers;
	@FindBy(xpath="(//a[@class='small-box-footer'])[3]") public WebElement clickCategory;
	@FindBy(xpath="//p[text()='Manage News']") public WebElement manageNews;
	
	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")
	private WebElement admin;
	@FindBy(xpath = "//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']")
	private WebElement adminField;
	@FindBy(xpath ="//i[@class='nav-icon fas fa-th-large']") public WebElement dashboard;
	@FindBy(xpath ="//p[text()='cdc']") public WebElement cdc;
	@FindBy(xpath="//p[text()='Sub Category']") public WebElement subCategory;
	
	public HomePage verifylogoutByAdmin() {
		admin.click();
		adminField.click();
		return this;
	}

	public boolean isLogoutButtonDisplayed() {
		return adminField.isDisplayed();
		
	}
	
	public HomePage clickDashboardMenu() throws InterruptedException
	{
		dashboard.click();
		wait.waitUntilElementToBeClickable(driver, cdc);
		return this;
	}
	
	public boolean iscdcDisplayed()
	{
		return cdc.isDisplayed();	
		
	}
	
	public AdminUsersPage clickAdminUsers()
	{
		adminUsers.click();
		return new AdminUsersPage(driver);
	}
	
	public CategoryPage clickCategory()
	{
		clickCategory.click();
		return new CategoryPage(driver);
	}
	
	public ManageNewsPage clickManageNews()
	{
		manageNews.click();
		return new ManageNewsPage(driver);
	}
	
	public SubCategoryPage clickSubCategory()
	{
		subCategory.click();
		return new SubCategoryPage(driver);
	}

}
