package pages;

import base.Keywords;

public class HomePage extends Keywords
{
	public void home(String ID) 
	{
		getTitle("Home - Cyclos");
		click_id(ID);
	}

}
