package day12;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindows1 {
	FirefoxDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("http://citibank.com");
	}
	
	@Test
	public void multipleWindowTest() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='tab1']/div[2]/ul/li/a")).click();
		Set<String> windowids=driver.getWindowHandles();
		Iterator<String> it=windowids.iterator();
		while(it.hasNext())
		{
		   driver.switchTo().window(it.next());
		   try
		   {
			   driver.findElement(By.xpath("//*[@id='content']/div[1]/div/div[2]/div[3]/a")).click();
			   break;
		   }
		   catch(Exception e)
		   {
			   
		   }
		}
	}

}
