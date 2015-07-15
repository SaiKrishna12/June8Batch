package day18;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Inputfields {
	FirefoxDriver driver=null;
	
	@BeforeMethod
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("http://facebook.com");
	}
	@Test
	public void inputBoxtest()
	{
		List<WebElement> myinput=driver.findElements(By.xpath
				    ("//input[@type='text' or @type='password']"));
		System.out.println(myinput.size());
		String[] str={"one","two","three","four","five","six","seven","eight"};
		for(int i=0;i<myinput.size();i++)
		{
			myinput.get(i).sendKeys(str[i]);
		}
	}
	
	
	

}
