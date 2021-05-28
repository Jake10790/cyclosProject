package Runner;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CyclosNewUser {
	
	public static WebDriver driver;

	public static void main(String[] args) throws Exception 
	{
		registerNewUser("Jagadeesh", "Jake10790", "9789018583", "email@123.com", 1);
		Thread.sleep(5000);
		//driver.quit();
		
	}
	public static void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.cyclos.org/ui/home");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
	
	public static void homePage()
	{
		String actual = driver.getTitle();
		String expected = "Home - Cyclos";
		if(actual.contentEquals(expected))
		{
			System.out.println("Test Pass");
		}
		driver.findElement(By.id("login-link")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	public static void preloginPage()
	{
	
		String xpath_register = "//*[text()=' Not a user yet? Register here. ']";
		System.out.println("You are in "+" "+driver.getTitle());
		driver.findElement(By.xpath(xpath_register)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	public static void registerNewUser(String f_name,String l_name,String mob,String email,int z)
	{
		launchBrowser();
		homePage();
		preloginPage();
		
		driver.findElement(By.id("id_1")).sendKeys(f_name);
		driver.findElement(By.id("id_2")).sendKeys(l_name);
		driver.findElement(By.id("id_3")).sendKeys(email);
		driver.findElement(By.xpath("//label[text()=' Female ']")).click();
		driver.findElement(By.id("id_4")).sendKeys(mob);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select cel = new Select(driver.findElement(By.xpath("//button[@type='button' and @id='business_type']")));
		cel.selectByIndex(z);
		List<WebElement> cel1 = cel.getOptions();
		for(WebElement i : cel1)
		{
			System.out.println(i);
		}
		
		
		//driver.findElement(By.xpath(xpath_BType));

	}
	
	//public void login()
	//{
		//String xpath_user = "//input[@autocomplete='username']";
		//String xpath_pass = "//input[@type='password']";
		//String xpath_submit = "//*[text()='Submit']";
		//driver.findElement(By.xpath(xpath_user)).sendKeys("demo");
		//driver.findElement(By.xpath(xpath_pass)).sendKeys("1234");
		//driver.findElement(By.xpath(xpath_submit)).click();
	//}

}
