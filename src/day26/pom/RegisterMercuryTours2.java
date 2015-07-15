package day26.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterMercuryTours2 {
	
	@FindBy(xpath="html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")
	WebElement actText;
	public boolean validateRegistration(String exptext)
	{
		if(actText.getText().contains(exptext))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

}
