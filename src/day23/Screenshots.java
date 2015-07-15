package day23;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Screenshots {
	@Parameters("browser")
	@Test
	public void screenshotTest(String b) throws IOException
	{
	DesiredCapabilities cap=null;
	if(b.equals("firefox"))
	{
		cap=DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.ANY);
	}
	else if(b.equals("chrome"))
	{
		cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
	}
	RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
	driver.get("http://newtours.demoaut.com");
	List<WebElement> links=driver.findElements(By.tagName("a"));
	for(int i=0;i<links.size();i++)
	{
		if(!links.get(i).getText().isEmpty())
		{
			String linkname=links.get(i).getText();
			links.get(i).click();
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile,new File("C:\\Users\\sai\\Desktop\\"+b+"Screenshots\\"+linkname+".png"));
			driver.navigate().back();
			links=driver.findElements(By.tagName("a"));
		}
	}
	}

}
