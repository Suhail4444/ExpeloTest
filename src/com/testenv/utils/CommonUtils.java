package com.testenv.utils;

public class CommonUtils implements FileConstants
{
	public static void loadUrl() 
	{
		SeleniumUtils.loadUrl(PropertyUtil.getServerValue(url));
	}
}
