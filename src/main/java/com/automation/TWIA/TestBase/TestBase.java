package com.automation.TWIA.TestBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.TWIA.config.config;
import com.automation.TWIA.config.loggerClass;
import com.automation.TWIA.dataRead.excelRead;


public class TestBase{

	public static final Logger log= Logger.getLogger(TestBase.class.getName());

	public WebDriver driver;
	public static int status1=0;
	public static int RowNo=0;

    config configObj= new config();
	loggerClass loggerClassObj= new loggerClass();
	excelRead excelReadObj;


	public void setUp(String url) {

		loggerClassObj.logs();
		browserLaunch();

		log.info("Started Browser..");

		getUrl(url);

		log.info("triggered url in browser..");

	}

	//	

	public void browserLaunch() {

		configObj= new config();

		if(configObj.browser.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver");
			driver= new ChromeDriver();
		}
		else{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver");
			driver= new FirefoxDriver();
		}


	}

	public void getUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}
	
	public void loadTestData( String excelName) {
		String path= System.getProperty("user.dir")+"/src/main/java/com/automation/TWIA/dataRead/";
		excelReadObj= new excelRead(path+excelName);
		log.info("Test data sheet loaded successfully ..");
	}

	



}



