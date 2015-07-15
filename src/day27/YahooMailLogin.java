package day27;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class YahooMailLogin {

	private static Logger log=Logger.getLogger(YahooMailLogin.class);
	public static void main(String[] args) {
		
		DOMConfigurator.configure("log4j.xml");
		FirefoxDriver driver=new FirefoxDriver();
		log.info("Browser launched");
		driver.navigate().to("http://yahoomail.com");
		log.info("Navigated to url");
		driver.findElement(By.name("username")).sendKeys("saikrishna");
		log.info("Entered the username");
		driver.findElement(By.id("login-passwd")).sendKeys("passw@123");
		log.info("Entered the password");
		driver.findElement(By.id("login-signin")).click();
		log.fatal("Click on Signin");
	}

}
