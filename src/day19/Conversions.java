package day19;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Conversions {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream f=new FileInputStream("E:\\June8Batch\\Webdriver\\src\\com\\qedge\\excelfiles\\registration.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		Iterator<Row> row=ws.iterator();
		row.next();
		while(row.hasNext())
		{
			Row r=row.next();
			double  d=r.getCell(2).getNumericCellValue();
			long l=(long)d;
			System.out.println(l);
			String str=Long.toString(l);
			System.out.println(str);
			
			Long.toString((long)r.getCell(2).getNumericCellValue());
			
			
			
			
			
			
	    }
	}

}
