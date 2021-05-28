package pages;

import base.Keywords;

public class RegisterationPage extends Keywords
{
	public void newUser(String name,String login, String email,String mobile) 
	{
		sendKey_id("id_1", name);
		sendKey_id("id_2", login);
		sendKey_id("id_3", email);
		click_xpath("//label[text()=' Female ']");
		sendKey_id("id_4", mobile);
	}
}
