package day22;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Login  extends Constants{
	LoginActions keys=new LoginActions();
	Method[] methods=keys.getClass().getMethods();
	@Test
	public void loginTest() throws IOException, InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		int r=eo.rowCount(path1,0);
		for(int i=1;i<r;i++)
		{
			
			String action=eo.excelRead(path1,0,i,3);
			executeMethods(action);
		}
	}
	public void executeMethods(String action) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		for(int i=0;i<methods.length;i++)
		{
			if(action.equals(methods[i].getName()))
			{
				methods[i].invoke(keys);
			}
		}
	}

}
