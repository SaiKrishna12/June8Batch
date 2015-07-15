package day9;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CaptchaAutomation {
	
		FirefoxDriver driver;
		@BeforeMethod
		public void setUp()
		{
			
			driver=new FirefoxDriver();
			driver.get("http://www.harvard.edu/feedback");
		}
		
		@Test
		public void cpatchaTest() throws InterruptedException
		{
			for(long z=1;z<9999999l;z++)
			{
			driver.findElement(By.id("edit-submitted-name")).sendKeys("tester"+z);
			driver.findElement(By.id("edit-submitted-email")).sendKeys("tester"+z+"@gmail.com");
			driver.findElement(By.id("edit-submitted-comment")).sendKeys("Stupid change the captcha");
			String x=driver.findElement(By.xpath("//*[@id='webform-client-form-1884']/div/fieldset/div/div[2]/span")).getText();
			String[] a=x.split(" ");
			int i=Integer.parseInt(a[0]);
			int j=Integer.parseInt(a[2]);
			int k=i+j;
			String str=Integer.toString(k);
			driver.findElement(By.id("edit-captcha-response")).sendKeys(str);
			Thread.sleep(5000);
			//driver.findElement(By.name("op")).click();
			driver.get("http://www.harvard.edu/feedback");
			}
		}

}
