package hrmPIM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Hrm.genericLib.Browser;
import com.Hrm.genericLib.ExcelLib;
import com.Hrm.genericLib.WebDriverCommonLib;

import pageObjectLib.AddEmp;
import pageObjectLib.Common;
import pageObjectLib.Dashboard;
import pageObjectLib.EmpInfo;
import pageObjectLib.Login;
import pageObjectLib.PersonalDetails;

@Listeners(com.Hrm.genericLib.SampleListenerTest.class)
public class CreateEmployeeTest {

	
	@Test
	public void createEmp() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		WebDriver driver=Browser.getBrowser();
		ExcelLib eLib = new ExcelLib();
		Login loginPage = PageFactory.initElements(driver, Login.class);
		Dashboard dboard = PageFactory.initElements(driver, Dashboard.class);
		EmpInfo empinfo = PageFactory.initElements(driver, EmpInfo.class);
		AddEmp addEmp = PageFactory.initElements(driver, AddEmp.class);
		PersonalDetails prsnlDetil = PageFactory.initElements(driver, PersonalDetails.class);
		Common comn = PageFactory.initElements(driver, Common.class);
		WebDriverCommonLib clib = new WebDriverCommonLib();

		
		// Step1:Login to the Application
		loginPage.logintoApp();

		// Step2:Navigate to PIM module
		dboard.navigateToPim();

		// Step3:click add button in Employee Information page
		empinfo.navigateToAddEmp();

		// Step4:Add Employee and save
		String fname = eLib.getExcelData("Sheet1", 1, 4);
		String lname = eLib.getExcelData("Sheet1", 1, 5);
		addEmp.addEmp(fname, lname);

		// Step5:Verify Created Employee
		prsnlDetil.verifyEmp(fname);
		prsnlDetil.writeid();
		// Step6:logout
		comn.logout();
		driver.quit();

	}

	

}
