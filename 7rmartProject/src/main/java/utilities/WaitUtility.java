package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public WebDriver driver;
	public static int IMPLICITWAITDURATION = 10;
	public static int EXPLICITWAITDURATION = 10;
	public static int threadTime = 500;

	public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {

		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}

	public void waitUntilTheAlertIsPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITDURATION));
		wait.until(ExpectedConditions.alertIsPresent());

	}

	public void waitUntilElementToBeClickable(WebDriver driver, WebElement element) throws InterruptedException
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITDURATION));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitintilTheElementToBeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITDURATION));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	public void waitUntilTheTextToBePresent(WebDriver driver, WebElement element, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITDURATION));
		wait.until(ExpectedConditions.textToBePresentInElement(element, value));
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITWAITDURATION));
	}

}
