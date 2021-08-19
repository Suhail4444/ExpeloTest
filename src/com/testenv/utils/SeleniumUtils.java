package com.testenv.utils;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumUtils implements FileConstants
{
	static WebDriver driver = null;

	public static WebDriver getDriver()
	{
		if (null == driver) 
		{
			driverInstance();
		}
		return driver;
	}

	public static void driverInstance() 
	{
		if (PropertyUtil.getServerValue(BROWSER_TYPE).equalsIgnoreCase("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();
		    options.addArguments("--disable-blink-features=AutomationControlled");
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver(options);
		}
	}

	public static void quitDriver() 
	{
		if (null != driver) 
		{
			getDriver().quit();
			driver = null;
		}
	}
	
	public static void loadUrl(String url)
	{
		getDriver().manage().window().maximize();
		getDriver().get(url);
	}
	
	public static void refresh()
	{
		getDriver().navigate().refresh();
	}
	
	public static void clickByXPath(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ele)));
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		executor.executeScript("arguments[0].click();", until);
	}
	
	public static void clickById(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(ele))).click();
	}
	
	public static void selectByValueByXPath(String ele, String text)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ele)));
		Select select = new Select(element);
		select.selectByValue(text);
	}
	
	public static void clickByCssSelector(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ele))).click();
	}
	
	public static String getCssValueByXpath(String ele, String prop)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ele))).getCssValue(prop);
	}
	
	public static boolean isClickableByLinkText(WebElement ele) 
    {
        try{
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
	
	public static List<WebElement> findElementsByXPath(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ele)));
	}
	
	public static List<WebElement> findElementsByTagName(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName(ele)));
	}
	
	public static WebElement findElementByXPath(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ele)));
	}
	
	public static void clickByLinkText(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(ele))).click();
	}
	
	public static void clickByName(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(ele))).click();
	}
	
	public static List<WebElement> getAllWebElementsXpath(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ele)));
	}
	
	public static boolean isDisplayedByName(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		boolean flag = false;
		try {
			flag = wait.until(ExpectedConditions.elementToBeClickable(By.name(ele))).isDisplayed();
		} catch (Exception e) {
		}
		return flag;
	}
	
	public static boolean isDisplayedById(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		boolean flag = false;
		try {
			flag = wait.until(ExpectedConditions.elementToBeClickable(By.id(ele))).isDisplayed();
		} catch (Exception e) {
		}
		return flag;
	}
	
	public static boolean isDisplayedByXPath(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		boolean flag = false;
		try {
			flag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ele))).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean isEnabledByXPath(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		boolean flag = false;
		try {
			flag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ele))).isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean isDisplayedByLinkText(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		boolean flag = false;
		try {
			flag = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(ele))).isDisplayed();
		} catch (Exception e) {
		}
		return flag;
	}
	
	public static String getTextByLinkText(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		String text = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(ele))).getText();
		return text;
	}
	
	public static String getTextByXPath(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		String text = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ele))).getText();
		return text;
	}
	
	public static void sendKeysByXPath(String ele, String data)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ele)));
		until.clear();
		until.sendKeys(data);
	}
	
	public static void sendKeysById(String ele, String data)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.id(ele)));
		until.clear();
		until.sendKeys(data);
	}
	
	public static void sendKeysByName(String ele, String data)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.name(ele)));
		until.clear();
		until.sendKeys(data);
	}
	
	public static void sendKeysByCssSelector(String ele, String data)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ele)));
		until.clear();
		until.sendKeys(data);
	}
	
	public static void hoverByXpath(String ele)
	{
		Actions ac = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ele)));
		ac.moveToElement(until).build().perform();
	}
	
	
}
