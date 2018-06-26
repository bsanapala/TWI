package com.automation.TWIA.Test;

import com.automation.TWIA.TestBase.TestBase;
import com.automation.TWIA.Utils.commonUtils;
import com.automation.TWIA.dataRead.excelRead;
import com.automation.TWIA.pages.homePage;
import com.automation.TWIA.screenShots.Screenshots;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class test extends TestBase{

	public static final Logger log= Logger.getLogger(test.class.getName());
	
	homePage homePageobj;
	commonUtils utilObj;
	Screenshots screenshotobj;

	@Parameters({"URL"})
	@BeforeMethod
	public void startUp(String url) throws Exception {

		setUp(url);
		log.info("Browser launched");

		Thread.sleep(1000);

	}

	@Test
	public void TC1() {
		loadTestData("twia.xlsx");
		homePageobj= new homePage(driver);
		screenshotobj= new Screenshots();

		if(commonUtils.tc_not_match_found("TC1", "Data")) 
			throw new SkipException("Run Mode is set to No");
		status1 =0;

		String userName= excelRead.getCellData("Data", "UserName", RowNo);
		//Screenshots.captureScreenShot();
		String password= excelRead.getCellData("Data", "Password", RowNo);
		homePageobj.login(userName, password);
		//	screenshotobj.captureScreenShot(driver , "Loginpage_TC1");

		if(status1==1) {

			excelRead.setCellData1("Data", "Result", RowNo, "FAIL");

		}
		if(status1==0) {

			excelRead.setCellData1("Data", "Result", RowNo, "PASS");

		}


	}


	@Test
	public void TC2() {

		loadTestData("twia.xlsx");
		homePageobj= new homePage(driver);

		if(commonUtils.tc_not_match_found("TC2", "Data")) 
			throw new SkipException("Run Mode is set to No");
		status1 =0;

		String userName= excelRead.getCellData("Data", "UserName", RowNo);
		String password= excelRead.getCellData("Data", "Password", RowNo);
		homePageobj.login(userName, password);
		//	screenshotobj.captureScreenShot(driver , "Loginpage_TC2");

		if(status1==1) {

			excelRead.setCellData1("Data", "Result", RowNo, "FAIL");

		}
		if(status1==0) {

			excelRead.setCellData1("Data", "Result", RowNo, "PASS");

		}

	}

	@Test
	public void TC3() {

		loadTestData("twia.xlsx");
		homePageobj= new homePage(driver);

		if(commonUtils.tc_not_match_found("TC3", "Data")) 
			throw new SkipException("Run Mode is set to No");
		status1 =0;

		String userName= excelRead.getCellData("Data", "UserName", RowNo);
		String password= excelRead.getCellData("Data", "Password", RowNo);
		homePageobj.login(userName, password);
		//	screenshotobj.captureScreenShot(driver , "Loginpage_TC3");

		if(status1==1) {

			excelRead.setCellData1("Data", "Result", RowNo, "FAIL");

		}
		if(status1==0) {

			excelRead.setCellData1("Data", "Result", RowNo, "PASS");

		}

	}

	@Test
	public void TC4() {

		loadTestData("twia.xlsx");
		homePageobj= new homePage(driver);

		if(commonUtils.tc_not_match_found("TC4", "Data")) 
			throw new SkipException("Run Mode is set to No");
		status1 =0;

		String userName= excelRead.getCellData("Data", "UserName", RowNo);
		String password= excelRead.getCellData("Data", "Password", RowNo);
		homePageobj.login(userName, password);
		//	screenshotobj.captureScreenShot(driver , "Loginpage_TC4");

		if(status1==1) {

			excelRead.setCellData1("Data", "Result", RowNo, "FAIL");

		}
		if(status1==0) {

			excelRead.setCellData1("Data", "Result", RowNo, "PASS");

		}

	}
	@AfterMethod
	public void close(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()) {
			screenshotobj.captureScreenShot(driver , result.getName());
		}


		if(ITestResult.SUCCESS==result.getStatus()) {
			screenshotobj.captureScreenShot(driver , result.getName());
		}

		if(ITestResult.SKIP==result.getStatus()) {
			//screenshotobj.captureScreenShot(driver , result.getName());
		}

		driver.close();
	}

}
