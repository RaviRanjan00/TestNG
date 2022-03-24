package Listeners_Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(TestNG_Lis.class)
public class Base_Class {
				
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void BeforeTest(String brow)
	{
			
			System.out.println("Running browser : " + brow);
			if (brow.equals("chrome") )
			{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\RAVI RANJAN\\Downloads\\chromedriver_win32/chromedriver.exe");
				driver = new ChromeDriver();
			}else if (brow.equals("edge"))
			{
				System.setProperty("webdriver.edge.driver", "C:\\Users\\RAVI RANJAN\\Downloads\\edgedriver_win64/msedgedriver.exe");
				 driver = new EdgeDriver();
				 driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
			}
	}
	@Parameters("url")
	@Test
	public void Test2(String url)
	{
		driver.get(url);
		String Actual_Title = driver.getTitle();
		String Expected_Title = "Google";
		Assert.assertEquals(Actual_Title, Expected_Title);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Facebook");;
		driver.findElement(By.className("gNO89b")).click();;
		String Actual = driver.getTitle();
		String Expected = "Facebook - Google Search";
		Assert.assertEquals(Actual, Expected);
		
	}
	@AfterMethod
	public void AfterTest() 
	{
		driver.quit();
	}
	
	public void takeScreenshot() throws IOException
	{
	//	TakesScreenshot Scr=((TakesScreenshot)driver);
		File F = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(F, new File 
		("C:\\Users\\RAVI RANJAN\\Selenium\\TestNG\\src\\main\\java\\Listeners_Test/R.jpg"));
	}
			
	
}
