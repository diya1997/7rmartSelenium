package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//p[text()='Manage News']") public WebElement manageNews;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']") public WebElement newButton;
	@FindBy(xpath="//textarea[@placeholder='Enter the news']") public WebElement newsField;
	@FindBy(xpath="//button[@name='create']") public WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") public WebElement alert;
	
	public ManageNewsPage clickNewButton()
	{
		newButton.click();
		return this;
	}
	public ManageNewsPage enterTheNews(String news)
	{
		newsField.sendKeys(news);
		return this;
	}
	public ManageNewsPage clickSaveButton()
	{
		saveButton.click();
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
