package tests;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.SignUpData;
import pages.SignUpPage;
import utils.ExcelDataConfig;
import utils.StringSlicing;

public class SignUpTest {
	WebDriver driver;
	
	@Test(dataProvider="phptravelsData")
	public void signupTest(SignUpData data) throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/ehab/eclipse-workspace/tdd-automation-framework/src/test/java/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.phptravels.net/register");
		
		SignUpPage signup = new SignUpPage(driver);
		
		// Logic
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
		
		String fname = data.getFname();
		//fname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
		String firstCharFname = fname.substring(0, 1);
		if(firstCharFname.equals(firstCharFname.toUpperCase())) {
			System.out.println(firstCharFname);
			signup.fillInFnameTextField(data.getFname());
		}
		else
		{
			signup.fillInFnameTextField(data.getFname())
			      .fillInLnameTextField(data.getLname())
			      .fillInPhoneTextField(data.getPhone())
			      .fillInEmailTextField(data.getEmail())
			      .fillInPasswdTextField(data.getPasswd())
			      .fillInCPasswdTextField(data.getcPasswd())
			      .clickOnSignUpBtn();
		    Thread.sleep(4000);
		    this.takeSnapShot(driver, "/home/ehab/eclipse-workspace/tdd-automation-framework/test-output/snapshots/first_name_did_not_start_with_uppercase_failure_"+dateFormat.format(date)+".png");
		    org.testng.Assert.fail("FAIL: FIRST LETTER FOR FIRST NAME WAS NOT UPPERCASE");
		}
		String firstCharLname = data.getLname().substring(0, 1);
		if(firstCharLname.equals(firstCharLname.toUpperCase()))
		{
			//String lname = data.getLname();
			//lname = lname.substring(0, 1).toUpperCase() + lname.substring(1);
			signup.fillInLnameTextField(data.getLname());
		}
		else if(data.getFname().equalsIgnoreCase(data.getLname())) {
			System.out.println("FAIL: fname: "+data.getFname()+", lname: "+data.getLname());
			signup.fillInLnameTextField(data.getLname())
				  .fillInPhoneTextField(data.getPhone())
				  .fillInEmailTextField(data.getEmail())
				  .fillInPasswdTextField(data.getPasswd())
				  .fillInCPasswdTextField(data.getcPasswd())
				  .clickOnSignUpBtn();
			Thread.sleep(4000);
			this.takeSnapShot(driver, "/home/ehab/eclipse-workspace/tdd-automation-framework/test-output/snapshots/first_name_equals_to_last_name_failure_"+dateFormat.format(date)+".png");
			org.testng.Assert.fail("FAIL: FIRST NAME EQUALS LAST NAME");
		}
		else
		{
			signup.fillInLnameTextField(data.getLname())
				  .fillInPhoneTextField(data.getPhone())
				  .fillInEmailTextField(data.getEmail())
				  .fillInPasswdTextField(data.getPasswd())
				  .fillInCPasswdTextField(data.getcPasswd())
				  .clickOnSignUpBtn();
			Thread.sleep(4000);
			this.takeSnapShot(driver, "/home/ehab/eclipse-workspace/tdd-automation-framework/test-output/snapshots/last_name_did_not_start_with_uppercase_failure_"+dateFormat.format(date)+".png");
			org.testng.Assert.fail("FAIL: FIRST LETTER FOR LAST NAME WAS NOT UPPERCASE");
		}
		
		String phone = data.getPhone();
		int phone_len = phone.length();
		System.out.println(phone_len);
		utils.StringSlicing slice = new StringSlicing();
		String firstTwoPhoneNumbers = slice.slice_range(phone, 0, 2);
		System.out.println(firstTwoPhoneNumbers);
		if(phone_len==11 && firstTwoPhoneNumbers.equals("01")) {
			signup.fillInPhoneTextField(data.getPhone());
		}
		else
		{
			signup.fillInPhoneTextField(data.getPhone())
			  	  .fillInEmailTextField(data.getEmail())
			  	  .fillInPasswdTextField(data.getPasswd())
			  	  .fillInCPasswdTextField(data.getcPasswd())
			  	  .clickOnSignUpBtn();
			Thread.sleep(4000);
			this.takeSnapShot(driver, "/home/ehab/eclipse-workspace/tdd-automation-framework/test-output/snapshots/wrong_phone_failure_"+dateFormat.format(date)+".png");
			System.out.println("FAIL: WRONG PHONE FORMAT");
			org.testng.Assert.fail("FAIL: WRONG PHONE FORMAT");
		}
		
		String email = data.getEmail();
		if(email.contains("@") && email.contains("."))
		{
			//TODO: should not exist in the saved file scrapped from http request
			signup.fillInEmailTextField(data.getEmail());
		}
		else
		{
			signup.fillInEmailTextField(data.getEmail())
		  	      .fillInPasswdTextField(data.getPasswd())
		  	      .fillInCPasswdTextField(data.getcPasswd())
		  	      .clickOnSignUpBtn();
			Thread.sleep(4000);
			this.takeSnapShot(driver, "/home/ehab/eclipse-workspace/tdd-automation-framework/test-output/snapshots/wrong_email_format_failure_"+dateFormat.format(date)+".png");
			System.out.println("FAIL: WRONG EMAIL FORMAT");
			org.testng.Assert.fail("FAIL: WRONG EMAIL FORMAT");
		}
		
		String passwd = data.getPasswd();
		boolean hasUppercase = !passwd.equals(passwd.toLowerCase());
		boolean hasLowercase = !passwd.equals(passwd.toUpperCase());
		System.out.println(hasUppercase +" "+ hasLowercase);
		if(hasLowercase && hasUppercase && passwd.length() <= 8)
		{
			signup.fillInPasswdTextField(data.getcPasswd());
		}
		else
		{
			signup.fillInPasswdTextField(data.getPasswd())
	  	          .fillInCPasswdTextField(data.getcPasswd())
	  	          .clickOnSignUpBtn();
			Thread.sleep(4000);
			this.takeSnapShot(driver, "/home/ehab/eclipse-workspace/tdd-automation-framework/test-output/snapshots/wrong_password_format_failure_"+dateFormat.format(date)+".png");
			System.out.println("FAIL: WRONG PASSWORD FORMAT");
			org.testng.Assert.fail("FAIL: WRONG PASSWORD FORMAT");
		}
		if(data.getPasswd().equals(data.getcPasswd()))
		{
			System.out.println(data.getPasswd());
			System.out.println(data.getcPasswd());
			signup.fillInCPasswdTextField(data.getcPasswd());
		}
		else
		{
			signup.fillInCPasswdTextField(data.getcPasswd())
	              .clickOnSignUpBtn();
			Thread.sleep(4000);
			this.takeSnapShot(driver, "/home/ehab/eclipse-workspace/tdd-automation-framework/test-output/snapshots/password_does_not_match_failure_"+dateFormat.format(date)+".png");
			System.out.println("FAIL: PASSWORD DOES NOT MATCH");
			org.testng.Assert.fail("FAIL: PASSWORD DOES NOT MATCH");
		}
		signup.clickOnSignUpBtn();
		Thread.sleep(4000);
		String validationLabel = signup.extractTextInDashboard();
		String last_name = data.getLname();
		last_name = last_name.substring(0, 1).toUpperCase() + last_name.substring(1);
		String expectedLabel = "Hi, "+fname+" "+last_name;
		System.out.println(validationLabel);
		System.out.println(expectedLabel);
		if(validationLabel.equals(expectedLabel))
		{
			System.out.println("Validation Passed!");
		}
		else
		{
			Thread.sleep(4000);
			this.takeSnapShot(driver, "/home/ehab/eclipse-workspace/tdd-automation-framework/test-output/snapshots/validation_failure_"+dateFormat.format(date)+".png");
			System.out.println("FAIL: VALIDATION FAILED OR COULDN'T FIND WEB ELEMENT");
			org.testng.Assert.fail("FAIL: VALIDATION FAILED");
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("Test Completed");
	}
	
	@DataProvider(name="phptravelsData")
	public SignUpData[] passData(){
		ExcelDataConfig config = new ExcelDataConfig("/home/ehab/eclipse-workspace/tdd-automation-framework/src/test/java/data/user_info.xlsx");
		int rows = config.getRowCount(0);
		SignUpData[] data = new SignUpData[rows];
		for(int i=0; i<rows; i++) {
			SignUpData oneSignUpData = new SignUpData();
			oneSignUpData.setFname(config.getData(0, i, 0));
			oneSignUpData.setLname(config.getData(0, i, 1));
			oneSignUpData.setPhone(config.getData(0, i, 2));
			oneSignUpData.setEmail(config.getData(0, i, 3));
			oneSignUpData.setPasswd(config.getData(0, i, 4));
			oneSignUpData.setcPasswd(config.getData(0, i, 5));
			data[i]=oneSignUpData;
		}
		return data;
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		Reporter.log("<a href='"+ DestFile.getAbsolutePath() + "'> <img src='"+ DestFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		}
}
