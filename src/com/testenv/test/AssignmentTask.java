package com.testenv.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.testenv.pages.HomePage;
import com.testenv.utils.AbstractReport;
import com.testenv.utils.CommonUtils;
import com.testenv.utils.FileConstants;
import com.testenv.utils.PropertyUtil;
import com.testenv.utils.SeleniumUtils;

public class AssignmentTask extends AbstractReport implements FileConstants
{
	@Test
	public void test1() throws Exception
	{
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		assertEquals(HomePage.isAlertButtonDisplayed(), true);
		assertEquals(HomePage.isInfoButtonDisplayed(), true);
		assertEquals(HomePage.isSuccessButtonDisplayed(), true);
	}
	
	@Test
	public void test2() throws Exception
	{
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		assertEquals(HomePage.getCssValueOfAlertButton(), "rgba(198, 15, 19, 1)");
		
		assertEquals(HomePage.getCssValueOfInfoButton(), "rgba(43, 166, 203, 1)");
		assertEquals(HomePage.getCssValueOfSuccessButton(), "rgba(93, 164, 35, 1)");
	}
	
	@Test
	public void test3() throws Exception
	{
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		assertEquals(HomePage.isAlertButtonEnabled(), true);
		assertEquals(HomePage.isInfoButtonEnabled(), true);
		assertEquals(HomePage.isSuccessButtonEnabled(), true);
	}
	
	@Test
	public void test4() throws Exception
	{
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		assertEquals(HomePage.isTableisDisplayed(), true);
	}
	
	@Test
	public void test5() throws Exception
	{
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		String answer = HomePage.getAnswer().replace("Answer: ", "");
		System.out.println(answer.replace("Answer: ", ""));
		assertTrue(StringUtils.isNumeric(answer));
		SeleniumUtils.refresh();
		TimeUnit.SECONDS.sleep(5);
		String answer2 = HomePage.getAnswer().replace("Answer: ", "");
		System.out.println(answer);
		assertTrue(StringUtils.isNumeric(answer));
		assertNotEquals(answer2, answer);
	}
	
	@Test
	public void test11() throws Exception
	{
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		List<WebElement> tableRows = HomePage.getTableRows();
		for (int i = 1; i < tableRows.size()+1; i++) 
		{
			List<WebElement> findElementsByXPath = SeleniumUtils.findElementsByXPath(PropertyUtil.getObjectValue(TABLE_ROWS)+"["+i+"]/td");
			for (int j = 0; j < findElementsByXPath.size(); j++) 
			{
				assertTrue(findElementsByXPath.get(6).findElement(By.linkText(PropertyUtil.getObjectValue(EDIT))).isDisplayed());
				assertTrue(findElementsByXPath.get(6).findElement(By.linkText(PropertyUtil.getObjectValue(DELETE))).isDisplayed());
			}
		}
	}
	
	@Test
	public void test12() throws Exception
	{
		getMethodName();
		String name = "Phaedrum4";
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		List<WebElement> tableRows = HomePage.getTableRows();
		for (int i = 1; i < tableRows.size()+1; i++) 
		{
			List<WebElement> findElementsByXPath = SeleniumUtils.findElementsByXPath(PropertyUtil.getObjectValue(TABLE_ROWS)+"["+i+"]/td");
			for (int j = 0; j < findElementsByXPath.size(); j++) 
			{
				if (name.equalsIgnoreCase(findElementsByXPath.get(5).getText())) 
				{
					findElementsByXPath.get(6).findElement(By.linkText(PropertyUtil.getObjectValue(DELETE))).click();
					break;
				}
			}
		}
		assertFalse(SeleniumUtils.isDisplayedByXPath("//*[text()='"+name+"']"));
	}
	
	@Test
	public void test6() throws Exception
	{
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		List<WebElement> tableHeaders = HomePage.getTableHeaders();
		assertEquals(tableHeaders.size(), 7);
	}
	
	@Test
	public void test7() throws Exception
	{
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		List<WebElement> tableRows = HomePage.getTableHeaders();
		assertEquals(tableRows.size(), 7);
	}
	
	@Test
	public void test8() throws Exception
	{
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		List<WebElement> tableRows = HomePage.getTableHeaders();
		String[] split = headers_Columns.split(",");
		for (int i = 0; i < tableRows.size(); i++) 
		{
			assertEquals(tableRows.get(i).getText(), split[i]);
		}
	}
	
	@Test
	public void test10() throws Exception
	{
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		assertEquals(HomePage.isFooterLinkisDisplayed(), true);
	}
	
	@Test
	public void test9() throws Exception
	{
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		List<WebElement> tableRows = HomePage.getTableRows();
		List<WebElement> tableDatas = HomePage.getTableDatas();
		for (int i = 0; i < tableRows.size(); i++) 
		{
			label:
			for (int j = tableDatas.size()-1; j > 0;) 
			{
				assertTrue(SeleniumUtils.isClickableByLinkText(tableDatas.get(j).findElement(By.linkText(PropertyUtil.getObjectValue(DELETE)))));
				break label;
			}
		}
	}
}
