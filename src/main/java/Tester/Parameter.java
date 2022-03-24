package Tester;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
	WebDriver driver;
	
	
	
	@Parameters({"browser","url"})
	@Test(priority = 0)
	public void launchURL(String browser, String url) throws IOException
	{
		
		System.out.println("Running browser : " + browser);
		if (browser.equals("chrome") )
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\RAVI RANJAN\\Downloads\\chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\RAVI RANJAN\\Downloads\\edgedriver_win64/msedgedriver.exe");
			 driver = new EdgeDriver();
		}
		
		driver.get(url);
		String A = driver.getTitle();
		if (A.equals("Google"))
		{
			System.out.println("Google");
		}
		Assert.assertEquals(A, "Google");
			
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		takesScreenshot("google");

	}
	@Parameters({"browser","url2"})
	@Test(priority = 1)
	public void SecondTest(String browser, String url2) throws IOException
	{
		System.out.println("Running browser : " + browser);
		if (browser.equals("chrome") )
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\RAVI RANJAN\\Downloads\\chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\RAVI RANJAN\\Downloads\\edgedriver_win64/msedgedriver.exe");
			 driver = new EdgeDriver();
		}
		
		driver.get(url2);
		driver.getTitle();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		takesScreenshot("facebook");

		
	}
	@Parameters({"browser","url3"})
	@Test(priority = 2)
	public void ThirdTest(String browser, String url3) throws IOException
	{
		System.out.println("Running browser : " + browser);
		if (browser.equals("chrome") )
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\RAVI RANJAN\\Downloads\\chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\RAVI RANJAN\\Downloads\\edgedriver_win64/msedgedriver.exe");
			 driver = new EdgeDriver();
		}
		
		driver.get(url3);
		driver.getTitle();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		takesScreenshot("youtube");

		
	}
	@AfterTest
	public void takesScreenshot(String F1) throws IOException
	{
		TakesScreenshot scr = ((TakesScreenshot)driver);
		File F = scr.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(F, new File ("C:\\Users\\RAVI RANJAN\\Selenium\\TestNG\\src\\main\\java\\Tester"
		+F1+".jpg"));
		
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
		
	}
	
	
	
	
}
