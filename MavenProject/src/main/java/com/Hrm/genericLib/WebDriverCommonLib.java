package com.Hrm.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	
	public void waitforPageToLoad(){
		Browser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void waitforElementPresent(WebElement dObj){
		WebDriverWait wait= new WebDriverWait(Browser.driver, 10);
		wait.until(ExpectedConditions.visibilityOf(dObj));
		
	}

}
