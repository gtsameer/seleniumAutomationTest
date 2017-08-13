package pageObjectLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Hrm.genericLib.Browser;
import com.Hrm.genericLib.Constants;

public class Login extends com.Hrm.genericLib.WebDriverCommonLib{
	
	@FindBy(id="txtUsername")
	WebElement usernameEdit;
	
	@FindBy(id="txtPassword")
	WebElement passwordEdit;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	public void logintoApp(){
		
		waitforPageToLoad();
		Browser.driver.get(Constants.url);
		Browser.driver.manage().window().maximize();
		waitforElementPresent(usernameEdit);
		usernameEdit.sendKeys(Constants.username);
		passwordEdit.sendKeys(Constants.password);
		loginBtn.click();
	}

}
