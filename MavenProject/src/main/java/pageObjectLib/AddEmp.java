package pageObjectLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmp {
	
	@FindBy(id="firstName")
	WebElement fnameEdit;
	
	@FindBy(id="lastName")
	WebElement lnameEdit;
	
	@FindBy(id="btnSave")
	WebElement savebtn;
	
	public void addEmp(String fname,String lname){
		fnameEdit.sendKeys(fname);
		lnameEdit.sendKeys(lname);
		savebtn.click();
	}
	
	
	
	

}
