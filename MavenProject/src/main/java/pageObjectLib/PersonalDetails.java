package pageObjectLib;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Hrm.genericLib.ExcelLib;
import com.sun.media.sound.InvalidFormatException;

public class PersonalDetails {
	ExcelLib elib= new ExcelLib();
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	WebElement empFullname;
	
	@FindBy(id="personal_txtEmployeeId")
	WebElement empidfield;
	
	//@FindBys(@FindBy(xpath="//div[@id='profile-pic']/h1"))
	//List<WebElement> empFullnames;
	
	//@FindAll(@FindBy(xpath="//div[@id='profile-pic']/h1"))
	//List<WebElement> empNames;
	
		
	public void verifyEmp(String firstName){
		String empName=empFullname.getText();
		System.out.println(empName);
		//Assert.assertEquals("a", "b");
		Assert.assertTrue(empName.contains(firstName), "Employee is not created");
	}
	public void writeid() throws EncryptedDocumentException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException{
		String empid=empidfield.getAttribute("value");
		elib.setExcelData("Sheet1", 1, 7, empid);
		
		
	}

}
