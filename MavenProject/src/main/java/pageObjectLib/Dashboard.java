package pageObjectLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard {
	
	@FindBy(id="menu_pim_viewPimModule")
	WebElement pimbtn;
	
	public void navigateToPim(){
		pimbtn.click();
	}

}
