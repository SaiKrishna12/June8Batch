package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class LinksTesting1 {

	public static void main(String[] args) {
		ProfilesIni pr=new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("SeleniumUser");
		FirefoxDriver driver=new FirefoxDriver(fp);
		driver.get("http://google.com");
		driver.findElement(By.linkText("Gmail")).click();
		String expTitle="Gmail - Free Storage and Email from Google";
		String actTitle=driver.getTitle();
		if(actTitle.equals(expTitle))
		{
			System.out.println("Gmail link working correctly");
		}
		else
		{
			System.out.println("Gmail link not working correctly");
		}
		driver.close();
		

	}

}
