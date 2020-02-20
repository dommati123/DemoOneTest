package com.freyr.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utility.configReader;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentTabularReporter;



public class FreyeLogin {
	
	static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test1;
	static ExtentReports extent;
	
	public static WebDriver driver=null;
	
	@Test
	public void login() throws Exception
	{
		System.out.println("Welcome to TestNG");
		
		WebActions actions=new WebActions();
		configReader config= new configReader();
		htmlReporter=new ExtentHtmlReporter("extentreport.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		test1=extent.createTest("Launch Konnect");

		actions.launch();
		
		actions.navigate("http://qa.konnectco.com/");
		
		actions.driverwait(3);
		
		String mainWindow=driver.getWindowHandle();
		
		actions.enterText("//input[@id='UserName']", config.getUsername());
		
		actions.click("//input[@id='btnNext']");
		
		//actions.driverwait(3);
		
		Thread.sleep(4000);
		
		actions.selectFromDropDown("//div[@class='form-group']/select", "freyrsolutions.com");
		
		actions.enterText("//input[@id='Password1']", config.getpassword());
		
		
		actions.click("//input[@id='btnSave']");
		
		//actions.driverwait(3);
		
		Thread.sleep(4000);
		
		actions.click("//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[4]/a/i");
		actions.click("//*[text()='Leaves']");
		actions.click("//*[@class='btn btn-medium']");
		//Leave Year
		//select month
		//leave type
		//reason
		//from 
		//to
		actions.click("//a[text()='Apply']");
		actions.click("//table/tbody/tr[1]//td[1]");
		actions.click("//input[@value='Delete']");
		actions.click("//button[text()='OK']");
		actions.click("//a[@title='Timesheet']");
		actions.enterText("//input[@id='project_0']", "B-003-PS008");
		actions.click("//input[@id='project_0']/../ul/li[1]");
		actions.enterText("//input[@id='task_0']", "Task 1");
		actions.click("//input[@placeholder='Select task']/../ul/li[1]");
		actions.enterText("//input[@id='//small[text()='Mon']/../../../div[2]/div/div[3]/timer-control/div/input[1]']", "02");
		actions.click("//button[text()='Submit']");
		actions.click("//div[@class='time-delete ng-scope']");
		actions.click("//button[text()='OK']");
		
		
		
		
		
		
		actions.click("//a[contains(.,'My Leaves')]");
		
		String currentWindow=driver.getWindowHandle();
		
		if(!currentWindow.equals(mainWindow))
		{
			driver.close();
		driver.switchTo().window(mainWindow);
		}
		
		//actions.driverwait(2);
		
		Thread.sleep(4000);
		
		actions.click("//a[contains(.,'+ Apply Leave')]");
		
		Thread.sleep(4000);
		
		actions.click("//label[contains(.,'Leave Year')]/..//span[@class='k-select']");
		
		//actions.click("//li[contains(.,'LY - 01-Jan-2019 to 31-Dec-2019')]");
		
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//li[contains(.,'LY - 01-Jan-2020 to 31-Dec-2020')]")));
		
		
		actions.click("//label[contains(.,'Select Month')]/..//span[@class='k-select']");
		
		//actions.click("//li[contains(.,'Apr - 2020')]");
		
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//li[contains(.,'Apr - 2020')]")));
		
		
		//actions.selectFromDropDown("//select[@id='ddlMonth']", "May - 2020");
		
		actions.click("//label[contains(.,'Leave Type')]/..//span[@class='k-select']");
		
		//actions.click("//li[contains(.,'Casual - 0')]");
		
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//li[contains(.,'Casual - 0')]")));
		
		Thread.sleep(4000);
		
		//actions.click("//div[@class='date-selection']/label[contains(.,'01')]");
		
		actions.enterText("//div[contains(.,'Reason')]/textarea", "Personal Day Off");
		
		actions.click("//label[text()='From']//following-sibling::input[contains(@class,'leaveDatePicker')]");
		
		actions.selectFromDropDown("//select[@class='ui-datepicker-month']", "Apr");
		
		actions.selectFromDropDown("//select[@class='ui-datepicker-year']", "2020");
		
		actions.click("//table[@class='ui-datepicker-calendar']//tr[3]//td[contains(.,'12')]");
		
		
		actions.click("//label[text()='To']//following-sibling::input[contains(@class,'leaveDatePicker')]");
		
		actions.selectFromDropDown("//select[@class='ui-datepicker-month']", "Apr");
		
		actions.selectFromDropDown("//select[@class='ui-datepicker-year']", "2020");
		
		actions.click("//table[@class='ui-datepicker-calendar']//tr[3]//td[contains(.,'14')]");
		
		actions.click("//button[contains(text(),'Apply')]");
		
		actions.quit();
		


		extent.flush();
		
		
	}

}
