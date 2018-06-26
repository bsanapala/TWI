package com.automation.TWIA.Utils;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.TWIA.TestBase.TestBase;
import com.automation.TWIA.dataRead.excelRead;


public class commonUtils extends TestBase{

	public static final Logger log= Logger.getLogger(commonUtils.class.getName());

	WebDriver driver;
	excelRead excelReadObj;

	public commonUtils(WebDriver driver) {
		this.driver=driver;
	}

	public void WaitForElement(WebElement element, int timeOut) {

		WebDriverWait wait= new WebDriverWait(driver,timeOut);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e) {
			e.printStackTrace();
			status1=1;
		}
	}

	public void mouseOverAction(WebElement hoverElement, WebElement targetElement) {
		Actions action= new Actions(driver);

		try {
			action.moveToElement(hoverElement).perform();
			log.info("Mouse overed to the element " + hoverElement.toString());

			WaitForElement(targetElement, 5);
			action.moveToElement(targetElement).click().perform();
			log.info("Clicked on Target element" + targetElement);
		}

		catch(Exception e) {
			e.printStackTrace();
			status1=1;
		}

	}

	public void isElementDisplayed(WebElement element) {
		try {
			if(element.isDisplayed()) {
				log.info("element is displayed: " + element.toString());

			}
		}
		catch(Exception e) {
			log.info("element is not displayed : " + element.toString());
			status1 = 1;
		}
	}


	public boolean isElementPresent(WebElement element) {

		try {
			element.isDisplayed();
			log.info("Element is Present : " + element.toString());
			return  true;
		}
		catch(NoSuchElementException e) {
			log.info("Element is not Present : " + element.toString());
			status1=1;
			return  false;
		}

	}

	public boolean isElementEnabled(WebElement element) {

		try {
			element.isEnabled();
			log.info("Element is Enabled : " + element.toString());
			return  true;


		}
		catch(NoSuchElementException e) {
			log.info("Element is not Enabled : " + element.toString());
			status1=1;
			return  false;
		}
	}

	public boolean isElementSelected(WebElement element) {

		try {
			element.isSelected();
			log.info("Element is Selected : " + element.toString());
			return  true;


		}
		catch(NoSuchElementException e) {
			log.info("Element is not Selected : " + element.toString());
			status1=1;
			return  false;
		}

	}

	public static void verifyText(WebElement element, String expectedText) {

		try {
			element.isDisplayed();
			log.info("Element is displayed : "+ element.toString());
			try {
				element.getText().equals(expectedText);
				log.info("Actual Object text "+"("+ element.getText()+")"+ "is equals to " + "Expected text "+ expectedText);

			}
			catch(Exception e) {
				log.info("Actual Object text "+"("+ element.getText()+")"+ "is not equals to " + "Expected text "+ expectedText);
				status1=1;

			}

		}
		catch(NoSuchElementException e) {
			log.info("Element is not found : " + element.toString());
			status1=1;

		}

	}

	public static boolean tc_not_match_found(String Testcase, String SheetName) {

		//excelReadObj= new excelRead(SheetName);
		try {
			for (int i = 2; i <= excelRead.getRowCount(SheetName); i++)
			{
				if (excelRead.getCellData(SheetName, "TestCaseID", i).equals(Testcase))
				{
					log.info("Testcase: "+Testcase);
					log.info("TestCaseID match found");
					if (excelRead.getCellData(SheetName, "RunMode", i).equalsIgnoreCase("Yes")){
						RowNo=i;
						return false;
					}
					else
						return true;
				}
			}
			return false;
		} catch (Exception e) {

		}
		return false;
	}





}


