package day17;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertHandling {
	FirefoxDriver driver=null;
	Alert a;
	@BeforeMethod
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("http://google.com");
	}
	@Test
	public void alertTest() throws InterruptedException
	{
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('Hello Firends');");
		Thread.sleep(5000);*/
		boolean b=isAlertPresent();
		if(b==true)
		{
			a.accept();
		}
		else
		{
			System.out.println("Alert not present");
		}
	}
	
	public boolean isAlertPresent()
	{
		try
		{
		   a=driver.switchTo().alert();
		   return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}

