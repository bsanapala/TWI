package com.automation.TWIA.screenShots;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Screenshots {
	
	public static final Logger log=  Logger.getLogger(Screenshots.class.getName());
	
	
	public void captureScreenShot(WebDriver driver, String screenshotName) {
		 Calendar calendar = Calendar.getInstance();
		 calendar.add(calendar.DATE, 1);
		 SimpleDateFormat format1= new SimpleDateFormat("yyyy-MM-dd");
		 
		 String formatter = format1.format(calendar.getTime());
		 
		 try {
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
			//FuileUtils.
			File destFile= new File("./Screenshots/"+screenshotName+".png");
			FileUtils.copyFile(srcFile, destFile);
			log.info("Screenshot captured ");
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
