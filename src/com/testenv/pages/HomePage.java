package com.testenv.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.testenv.utils.AbstractReport;
import com.testenv.utils.FileConstants;
import com.testenv.utils.PropertyUtil;
import com.testenv.utils.SeleniumUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage extends AbstractReport implements FileConstants
{
	
	public static String getCssValueOfInfoButton()
	{
		testInfo("Get color of info button");
		return SeleniumUtils.getCssValueByXpath(PropertyUtil.getObjectValue(INFO_BUTTON), "background-color");
	}
	
	public static String getCssValueOfAlertButton()
	{
		testInfo("Click color of alert button");
		return SeleniumUtils.getCssValueByXpath(PropertyUtil.getObjectValue(ALERT_BUTTON), "background-color");
	}
	
	public static String getCssValueOfSuccessButton()
	{
		testInfo("Click color of success button");
		return SeleniumUtils.getCssValueByXpath(PropertyUtil.getObjectValue(SUCCESS_BUTTON), "background-color");
	}
	
	public static boolean isInfoButtonDisplayed()
	{
		testInfo("Is displayed info button");
		return SeleniumUtils.isDisplayedByXPath(PropertyUtil.getObjectValue(INFO_BUTTON));
	}
	
	public static boolean isAlertButtonDisplayed()
	{
		testInfo("Is displayed alert button");
		return SeleniumUtils.isDisplayedByXPath(PropertyUtil.getObjectValue(ALERT_BUTTON));
	}
	
	public static boolean isSuccessButtonDisplayed()
	{
		testInfo("Is displayed success button");
		return SeleniumUtils.isDisplayedByXPath(PropertyUtil.getObjectValue(SUCCESS_BUTTON));
	}
	
	public static boolean isInfoButtonEnabled()
	{
		testInfo("Is enabled info button");
		return SeleniumUtils.isEnabledByXPath(PropertyUtil.getObjectValue(INFO_BUTTON));
	}
	
	public static boolean isAlertButtonEnabled()
	{
		testInfo("Is enabled alert button");
		return SeleniumUtils.isEnabledByXPath(PropertyUtil.getObjectValue(ALERT_BUTTON));
	}
	
	public static boolean isSuccessButtonEnabled()
	{
		testInfo("Is enabled success button");
		return SeleniumUtils.isEnabledByXPath(PropertyUtil.getObjectValue(SUCCESS_BUTTON));
	}
	
	public static boolean isTableisDisplayed()
	{
		testInfo("verifying table is displayed");
		return SeleniumUtils.isDisplayedByXPath(PropertyUtil.getObjectValue(TABLE));
	}
	
	public static boolean isFooterLinkisDisplayed()
	{
		testInfo("verifying foooter link is displayed");
		return SeleniumUtils.isDisplayedByLinkText(PropertyUtil.getObjectValue(FOOTER_POWERED_BY));
	}
	
	public static List<WebElement> getTableRows()
	{
		testInfo("Getting all table rows");
		return SeleniumUtils.findElementsByXPath(PropertyUtil.getObjectValue(TABLE_ROWS));
	}
	
	public static List<WebElement> getTableDatas()
	{
		testInfo("Getting all table datas");
		return SeleniumUtils.findElementsByXPath(PropertyUtil.getObjectValue(TABLE_DATA));
	}
	
	public static List<WebElement> getTableHeaders()
	{
		testInfo("Getting all table headers");
		return SeleniumUtils.findElementsByXPath(PropertyUtil.getObjectValue(TABLE_HEADER));
	}
	
	public static String getAnswer() 
	{
		testInfo("Getting table answer");
		String answer = new String();
		List<WebElement> scripts = SeleniumUtils.findElementsByTagName("script");
		for (int i = 0; i < scripts.size(); i++) 
		{
			String focusText = scripts.get(i).getAttribute("innerHTML");
			if (focusText.contains("canvas.strokeText")) 
			{
				answer = focusText.substring(focusText.indexOf("Answer"), focusText.indexOf("',"));
				break;
			}
		}
		return answer;
	}
	
}
