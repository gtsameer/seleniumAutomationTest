package hrmPIM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

public class New1Test {
	WebDriver driver;
	ExcelLib eLib;
	Login loginPage;
	Dashboard dboard;
	EmpInfo empinfo;
	AddEmp addEmp;
	PersonalDetails prsnlDetil;
	Common comn;
	WebDriverCommonLib clib;

	
	@BeforeClass
	public void beforeclass(){
		driver=Browser.getBrowser();
		eLib = new ExcelLib();
		loginPage = PageFactory.initElements(driver, Login.class);
		dboard = PageFactory.initElements(driver, Dashboard.class);
		empinfo = PageFactory.initElements(driver, EmpInfo.class);
		addEmp = PageFactory.initElements(driver, AddEmp.class);
		prsnlDetil = PageFactory.initElements(driver, PersonalDetails.class);
		comn = PageFactory.initElements(driver, Common.class);
		clib = new WebDriverCommonLib();
	}
	@AfterClass
	public void afterclass(){
		driver.close();
		
	}
	@BeforeMethod
	public void beforemethod(){
		loginPage.logintoApp();
		
	}
	@AfterMethod
	public void aftermethod(){
		comn.logout();
		
	}
	
	
	
	@Test
	public void createEmp() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		dboard.navigateToPim();
		empinfo.navigateToAddEmp();
		String fname = eLib.getExcelData("Sheet1", 1, 4);
		String lname = eLib.getExcelData("Sheet1", 1, 5);
		addEmp.addEmp(fname, lname);
		prsnlDetil.verifyEmp(fname);
		prsnlDetil.writeid();
		
	}
	//@Test(dependsOnMethods={"createEmp"})
	public void delEmp() throws EncryptedDocumentException, InvalidFormatException,
			org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException {
		
		
		loginPage.logintoApp();
		dboard.navigateToPim();
		String id = eLib.getExcelData("Sheet1", 1, 7);
		try {
			empinfo.selectCheckbox(id);
			String expmsg = eLib.getExcelData("Sheet1", 1, 6);
			empinfo.delete();
			clib.waitforElementPresent(empinfo.conformationmsg);
			String actmsg = empinfo.conformationmsg.getText();
			Assert.assertTrue(actmsg.contains(expmsg), "employee not deleted");
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Employee not created, create employee first");
		}

		

	}

}
