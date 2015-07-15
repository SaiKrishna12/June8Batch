package day22;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginActions extends Constants {
	
	
	FirefoxDriver driver=null;
	public void launchBrowser()
	{
		driver=new FirefoxDriver();
	}
	public void navigate()
	{
		driver.get("http://gmail.com");
	}
	
	public void enterUsername() throws IOException
	{
		String loc=rp.read(path,"txt_username");
		driver.findElement(By.xpath(loc)).sendKeys("gandham.saikrishna");
	}
	public void clickNext() throws InterruptedException, IOException
	{
		String loc=rp.read(path,"btn_next");
		driver.findElement(By.id(loc)).click();
		Thread.sleep(1000);
	}
	public void enterPassword() throws IOException
	{
		String loc=rp.read(path,"txt_password");
		driver.findElement(By.id("Passwd")).sendKeys("pass@123");
	}
	public void clickLogin() throws IOException
	{
		String loc=rp.read(path,"btn_signin");
		driver.findElement(By.id("signIn")).click();
	}

}
