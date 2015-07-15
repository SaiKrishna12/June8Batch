package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class YahooLogin {

	
	public static void main(String[] args) {
		FirefoxDriver driver=new FirefoxDriver();
		driver.navigate().to("http://yahoomail.com");
		
		driver.findElement(By.name("username")).sendKeys("saikrishna");
		driver.findElement(By.id("login-passwd")).sendKeys("passw@123");
		driver.findElement(By.id("login-signin")).click();
		

	}

}
