package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Webtabletesting2 {
	FirefoxDriver driver=null;
	@BeforeMethod
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("http://www.timeanddate.com/worldclock/");
	}
	
	@Test
	public void webtabletest()
	{
		String part1="html/body/div[1]/div[7]/section[2]/div[1]/table/tbody/tr[";
		String part2="]/td[";
		String part3="]";
		for(int i=1;i<=37;i++)
		{
			for(int j=1;j<=8;j++)
			{
				String x=driver.findElement(By.xpath(part1+i+part2+j+part3)).getText();
				System.out.print(x+"    ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
	}

}
