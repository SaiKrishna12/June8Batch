package day23;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParalleTesting {
	@DataProvider(parallel=true)
	public Object[][] excelRead() throws IOException
	{
		FileInputStream f=new FileInputStream("C:\\Users\\sai\\Desktop\\Book1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Iterator<Row> row=ws.iterator();
		
		int r=ws.getLastRowNum();
		int c=ws.getRow(0).getLastCellNum();
		Object[][] data=new Object[r+1][c];
		System.out.println(r);
		System.out.println(c);
		for(int i=0;i<=r;i++)
		{
			for(int j=0;j<c;j++)
			{
				data[i][j]=ws.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return data;
		
		
		
	}
	
	
	@Test(dataProvider="excelRead")
	public void loginTest(String u,String p,String b) throws 
	                                       MalformedURLException, InterruptedException
	{
		System.out.println(b);
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
		RemoteWebDriver driver=new RemoteWebDriver(new URL
				          ("http://localhost:4444/wd/hub"),cap);
        driver.navigate().to("http://yahoomail.com");
        Thread.sleep(7000);
		
		driver.findElement(By.name("username")).sendKeys(u);
		driver.findElement(By.id("login-passwd")).sendKeys(p);
		driver.findElement(By.id("login-signin")).click();
	}


}
