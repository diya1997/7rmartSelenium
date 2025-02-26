package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtility;
import utilities.WaitUtility;

public class CategoryPage {
	
	public WebDriver driver;
	WaitUtility wait=new WaitUtility();
	PageUtility page=new PageUtility();
	public CategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//a[@onclick='click_button(1)']") public WebElement newButton;
	@FindBy(xpath="//input[@placeholder='Enter the Category']") public WebElement enterCategory;


	
	@FindBy(xpath="//input[@id='main_img']") public WebElement chooseFileButton;
	@FindBy(xpath="//input[@name='top_menu' and @value='yes']") public WebElement showOnTop;
	@FindBy(xpath="//button[text()='Save']") public WebElement saveButton;
	@FindBy(xpath="//input[@name='show_home' and @value='yes']") public WebElement showOnLeft;
	@FindBy(xpath="//a[@href='javascript:void(0)']") public WebElement searchButton;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']") public WebElement searchCategoryButton;
	@FindBy(xpath="//input[@placeholder='Category']") public WebElement searchCategoryField;
	@FindBy(xpath="//a[@class='page-link']") public WebElement pageNumber;
	@FindBy(xpath="//div[@id='imagePreview']") public WebElement imagePreview;
	
public CategoryPage clicktheNewButtonForAddingCategory()
{
	newButton.click();
	return this;
}

public boolean isImagePreviewDisplayed()
{
	return imagePreview.isDisplayed();
}


public CategoryPage enterCategoryOnCategory(String itemName)
{
	enterCategory.sendKeys(itemName);
	return this;
}

public CategoryPage imageUpload(String image)
{
	chooseFileButton.sendKeys(image);
	return this;
	
}
public CategoryPage clickRadioButtonForShowOnTop() throws InterruptedException
{
	
	wait.waitUntilElementToBeClickable(driver, showOnTop);
	page.javaScriptExecutorScroll(driver,showOnTop);
	showOnTop.click();
	return this;
}

public CategoryPage clickRadioButtonForShowOnLeft() throws InterruptedException
{
	
	showOnLeft.click(); 
	return this;
}

public CategoryPage saveNewCategoryItem() throws InterruptedException
{
	saveButton.click();
	return this;
}
public CategoryPage clickSearchButton()
{
	searchButton.click();
	return this;
}
public CategoryPage clickSearchCategoryButton()
{
	searchCategoryButton.click();
	return this;
}

public CategoryPage enterCategoryOnSearchField(String itemName)
{
	searchCategoryField.sendKeys(itemName);
	return this;
}
public boolean isPageNumberDisplayedAfterSearch()
{
	return pageNumber.isDisplayed();
}

}
