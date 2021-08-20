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
	public void testButtonDisplayed() throws Exception
	{
		// This test case checks buttons are displaying or not
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		assertEquals(HomePage.isAlertButtonDisplayed(), true);
		assertEquals(HomePage.isInfoButtonDisplayed(), true);
		assertEquals(HomePage.isSuccessButtonDisplayed(), true);
	}
	
	@Test
	public void testCheckColorOfButton() throws Exception
	{
		//This testcase validates color of the buttons
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		assertEquals(HomePage.getCssValueOfAlertButton(), "rgba(198, 15, 19, 1)");
		assertEquals(HomePage.getCssValueOfInfoButton(), "rgba(43, 166, 203, 1)");
		assertEquals(HomePage.getCssValueOfSuccessButton(), "rgba(93, 164, 35, 1)");
	}
	
	@Test
	public void testButtonEnabled() throws Exception
	{
		// This test case validates all buttons are enabled or not
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		assertEquals(HomePage.isAlertButtonEnabled(), true);
		assertEquals(HomePage.isInfoButtonEnabled(), true);
		assertEquals(HomePage.isSuccessButtonEnabled(), true);
	}
	
	@Test
	public void testTableDisplayed() throws Exception
	{  //This test case verifies table is displaying or not
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		assertEquals(HomePage.isTableisDisplayed(), true);
	}
	
	@Test
	public void testValidatesCanvasText() throws Exception
	{
		// This Testcase validates canvas value before and after refresh should be integer
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
	public void testEditDeleteLink() throws Exception
	{
		// This test case validates each row is having Edit and Delete link 
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
	public void testDeletefunctionality() throws Exception
	{
		// This testcase validates delete link is working or not and in our case it is failing as functionality is not working
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
	public void testColumnSize() throws Exception
	{
		// this test case validates column size of the table
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		List<WebElement> tableColumns = HomePage.getTableHeaders();
		assertEquals(tableColumns.size(), 7);
	}
	
	@Test
	public void testTableHeaderValues() throws Exception
	{ 
		//this test case validates header column values
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
	public void testFooterLink() throws Exception
	{
		//This test case validates Footer link
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		assertEquals(HomePage.isFooterLinkisDisplayed(), true);
	}
	
	@Test
	public void testdeleteLinkClickable() throws Exception
	{   
		//validates  Edit link is clickable
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
				assertTrue(SeleniumUtils.isClickableByLinkText(tableDatas.get(j).findElement(By.linkText(PropertyUtil.getObjectValue(EDIT)))));
				break label;
			}
		}
	}

	@Test
	public void testDataValues() throws Exception
	{
		// This testcase validates data values of the table
		getMethodName();
		testInfo("Load the URL");
		CommonUtils.loadUrl();
		List<WebElement> tableRows = HomePage.getTableRows();
		String[] splitDataValues = Table_Data_Values.split(",");
		for (int i = 1; i < tableRows.size()+1; i++) 
		{
			List<WebElement> findElementsByXPath = SeleniumUtils.findElementsByXPath(PropertyUtil.getObjectValue(TABLE_ROWS)+"["+i+"]/td");
			testInfo("******************ROW["+i+"]******************" );
			for (int j = 0; j < findElementsByXPath.size()-1; j++) 
			{
				testInfo("Actual Value :" +findElementsByXPath.get(j).getText());
				testInfo("Expected Value :" +splitDataValues[j]+(i-1));
				assertEquals(findElementsByXPath.get(j).getText(), splitDataValues[j]+(i-1));
				
			}
		}
	}

}
