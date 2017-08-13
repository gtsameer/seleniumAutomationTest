package hrmPIM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Hrm.genericLib.Browser;
import com.Hrm.genericLib.ExcelLib;
import com.Hrm.genericLib.WebDriverCommonLib;
import com.sun.media.sound.InvalidFormatException;

import pageObjectLib.Common;
import pageObjectLib.Dashboard;
import pageObjectLib.EmpInfo;
import pageObjectLib.Login;
@Listeners(com.Hrm.genericLib.SampleListenerTest.class)
public class DeleteEmployeeTest {


	@Test
	public void DelEmp() throws EncryptedDocumentException, InvalidFormatException,
			org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException {
		
		WebDriver driver= Browser.getBrowser();
		WebDriverCommonLib clib = new WebDriverCommonLib();
		ExcelLib elib = new ExcelLib();
		Login login = PageFactory.initElements(driver, Login.class);
		Dashboard dboard = PageFactory.initElements(driver, Dashboard.class);
		EmpInfo empinfo = PageFactory.initElements(driver, EmpInfo.class);
		Common comn = PageFactory.initElements(driver, Common.class);

		login.logintoApp();
		dboard.navigateToPim();
		String id = elib.getExcelData("Sheet1", 1, 7);
		try {
			empinfo.selectCheckbox(id);
			String expmsg = elib.getExcelData("Sheet1", 1, 6);
			empinfo.delete();
			clib.waitforElementPresent(empinfo.conformationmsg);
			String actmsg = empinfo.conformationmsg.getText();
			Assert.assertTrue(actmsg.contains(expmsg), "employee not deleted");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Employee not created, Create Employee first");
		}

		comn.logout();
		driver.quit();

	}

}
