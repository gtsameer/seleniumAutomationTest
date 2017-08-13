package com.Hrm.genericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ReportLib {
	
	public static void getScreenshot(String filename) throws IOException{
		EventFiringWebDriver ed= new EventFiringWebDriver(Browser.driver);
		File srcFile= ed.getScreenshotAs(OutputType.FILE);
		File destFile= new File("Screenshot/"+filename+".png");
		FileUtils.copyFile(srcFile, destFile);
		
	}

}
