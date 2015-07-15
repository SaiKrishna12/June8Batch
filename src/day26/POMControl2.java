package day26;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import day26.pom.RegisterMercuryTours1;
import day26.pom.RegisterMercuryTours2;
import day26.pom.WelcomeMercuryTours;

public class POMControl2 {
	@Test
	public void pomTest() throws IOException
	{
		FileInputStream f=new FileInputStream("E:\\June8Batch\\Webdriver\\src\\com\\qedge\\excelfiles\\registration.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Iterator<Row> row=ws.iterator();
		row.next();
		ProfilesIni pr=new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("SeleniumUser");
		FirefoxDriver driver=new FirefoxDriver(fp);
		driver.get("http://newtours.demoaut.com");
		WelcomeMercuryTours wm=PageFactory.initElements(driver,WelcomeMercuryTours.class);
		RegisterMercuryTours1 rm1=PageFactory.initElements(driver,RegisterMercuryTours1.class);
		RegisterMercuryTours2 rm2=PageFactory.initElements(driver,RegisterMercuryTours2.class);
		
		wm.menu.register();
		while(row.hasNext())
		{
			Row r=row.next();
			rm1.contactInformation(r);
			boolean b=rm2.validateRegistration(r.getCell(9).getStringCellValue());
			if(b==true)
			{
				r.createCell(12).setCellValue("Passed");
			}
			else
			{
				r.createCell(12).setCellValue("Failed");
			}
			driver.navigate().back();
		}
		
		FileOutputStream f1=new FileOutputStream("E:\\June8Batch\\Webdriver\\src\\com\\qedge\\resultexcelfiles\\registration.xlsx");
		wb.write(f1);
		f1.close();
		driver.quit();
	}

}
