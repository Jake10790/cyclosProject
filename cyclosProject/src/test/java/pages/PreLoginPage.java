package pages;

import base.Keywords;

public class PreLoginPage extends Keywords
{
	public void preLogin(String path) 
	{

		System.out.println("You are in "+" "+driver.getTitle());
		click_xpath(path);
	}
}
