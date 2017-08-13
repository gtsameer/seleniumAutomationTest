package com.Hrm.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.Hrm.genericLib.Constants;

public class Browser {
	public static WebDriver driver;
	
	public static WebDriver getBrowser(){
		if(Constants.browser.equals("firefox")){
			driver= new FirefoxDriver();
		}else if(Constants.browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", "C:\\selenium-2.53.1\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}else if(Constants.browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\selenium-2.53.1\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		return driver;
	}

}
