package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class SubCategoryPage {

	public WebDriver driver;
	public HomePage homePage;
	public int index=3;
	public SubCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category' and @class='btn btn-rounded btn-warning']") public WebElement reset;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']") public WebElement newButton;
	@FindBy(xpath="//select[@id='cat_id']") public WebElement categoryField;
	@FindBy(xpath="//input[@id='subcategory']") public WebElement subCategoryField;
	@FindBy(xpath="//input[@id='main_img']") public WebElement chooseFileButton;
	@FindBy(xpath="//button[@type='submit']") public WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") public WebElement alert;
	
	public SubCategoryPage clickResetButton()
	{
		reset.click();
		return this;
	}
	public SubCategoryPage clickNewButton()
	{
		newButton.click();
		return this;
	}
	public SubCategoryPage selectCategoryOnCategoryField()
	{
		PageUtility page=new PageUtility();
		page.selectDropDownWithIndexValue(categoryField, index);
		return this;
		
	}
	public SubCategoryPage enterTheSubCategory(String item)
	{
		subCategoryField.sendKeys(item);
		return this;
	}
	public SubCategoryPage imageUpload(String image)
	{
		chooseFileButton.sendKeys(image);
		return this;
	}
	
	public SubCategoryPage clickSaveButton()
	{
		saveButton.click();
		return this;
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
	
}
