package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Keywords 
{
	public static WebDriver driver;
	Properties F_load;
	public Keywords() 				//constructor
	{
		try {
			File F_path = new File("C:\\Java\\cyclosProject\\Property\\config.properties");
			FileInputStream Obj1;
			Obj1 = new FileInputStream(F_path);
			F_load = new Properties();
			F_load.load(Obj1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	public String getData(String Key) 
	{
		String Value = F_load.getProperty(Key);
		return Value;
	}
	public void launchBrowser(String URL,String path) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void getTitle(String expected)
	{
		String actual = driver.getTitle();

		if(actual.contentEquals(expected))
		{
			System.out.println("Test Pass");
		}
		else {System.out.println("Test Fail");}
	}
	public void gettext(String xpath, String expected)
	{
		String actual = driver.findElement(By.xpath(xpath)).getText();
		if(actual.contains(expected))
		{
			System.out.println("Test Pass");
		}
		else {System.out.println("Test Fail");}
	}
	public void sendKey_xpath(String xpath, String value)
	{
		driver.findElement(By.xpath(xpath)).sendKeys(value);
	}
	public void sendKey_id(String id, String value)
	{
		driver.findElement(By.id(id)).sendKeys(value);
	}
	public void click_id(String id)
	{
		driver.findElement(By.id(id)).click();
	}
	public void click_xpath(String path)
	{
		driver.findElement(By.xpath(path)).click();
	}
	
	

}
