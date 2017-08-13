package pageObjectLib;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Hrm.genericLib.Browser;
import com.Hrm.genericLib.ExcelLib;
import com.Hrm.genericLib.WebDriverCommonLib;
import com.sun.media.sound.InvalidFormatException;

public class EmpInfo {
	WebDriverCommonLib clib= new WebDriverCommonLib();
	ExcelLib elib= new ExcelLib();
	
	@FindBy(id="btnAdd")
	WebElement addbtn;
	
	@FindBy(id="btnDelete")
	WebElement deletebtn;
	
	@FindBy(id="dialogDeleteBtn")
	WebElement deletedialoguebtn;
	
	@FindBy(xpath="//div[@class='message success fadable']")
	public WebElement conformationmsg;
	
	public void navigateToAddEmp(){
		addbtn.click();
	}
	public void delete() throws EncryptedDocumentException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException{
		
		deletebtn.click();
		deletedialoguebtn.click();
		
		
		
	}
	
	public void selectCheckbox(String id){
		Browser.driver.findElement
			(By.xpath("//td[a[contains(text(),'"+id+"')]]/preceding-sibling::td/input")).click();
		
	}

}
