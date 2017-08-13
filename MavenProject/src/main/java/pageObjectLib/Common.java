package pageObjectLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Common {
	@FindBy(id="welcome")
	WebElement logoutImg;
	@FindBy(linkText="Logout")
	WebElement logoutlink;
	
	public void logout(){
		logoutImg.click();
		logoutlink.click();
	}

}
