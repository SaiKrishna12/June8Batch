package day18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) throws IOException {
		FileInputStream f=new FileInputStream("c:\\users\\sai\\desktop\\book1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Row r=null;
		Cell c=null;
		
		r=ws.getRow(0);
		c=r.getCell(1);
		c.setCellValue(100);
		
		r=ws.getRow(1);
		c=r.createCell(3);
		c.setCellValue("Qedge");
		
		r=ws.createRow(3);
		c=r.createCell(2);
		c.setCellValue("testing");
		
		
		FileOutputStream f1=new FileOutputStream("c:\\users\\sai\\desktop\\book1.xlsx");
		wb.write(f1);
		f1.close();
		
	}

}
