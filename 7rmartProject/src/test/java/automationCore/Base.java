package automationCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base {
	public WebDriver driver;
	Properties prop;
	FileInputStream fs;
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception// launch the browser
	{
		prop=new Properties();
		fs=new FileInputStream(Constants.CONFIGFILE);
		prop.load(fs);
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else {
			throw new Exception("invalid browser");
		}
		driver.get(prop.getProperty("url"));
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		WaitUtility wait=new WaitUtility();
		wait.implicitWait(driver);

	}

	@AfterMethod
	public void driverCloseAndQuit(ITestResult iTestResult) throws IOException
	{
	if(iTestResult.getStatus()==ITestResult.FAILURE)
	{
		ScreenshotUtility screenShot=new ScreenshotUtility();
		screenShot.getScreenshot(driver, iTestResult.getName());
	}
		driver.quit();
		
	}

}
