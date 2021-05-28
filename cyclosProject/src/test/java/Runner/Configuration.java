package Runner;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Keywords;
import pages.HomePage;
import pages.PreLoginPage;
import pages.RegisterationPage;

public class Configuration
{
	Keywords file;
	
	@BeforeTest
	public void launch() throws Exception
	{
		file = new Keywords();
		String URL =file.getData("URL1");
		String path = file.getData("path");
		file.launchBrowser(URL, path);
	}
	
	@Test
	public void	userCreation()
	{		
		HomePage obj1 = new HomePage();
		obj1.home("login-link");


		PreLoginPage obj2 = new PreLoginPage();
		obj2.preLogin("//*[text()=' Not a user yet? Register here. ']");

		RegisterationPage obj3 = new RegisterationPage();
		String name = file.getData("FullName");
		String login = file.getData("Login");
		String email = file.getData("email");
		String mobile = file.getData("mobile");
		obj3.newUser(name, login, email, mobile);
	}

	}


