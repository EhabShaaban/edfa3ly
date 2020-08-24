package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
	public void signupTest(SignUpData data) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/ehab/eclipse-workspace/tdd-automation-framework/src/test/java/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.phptravels.net/register");
		
		SignUpPage signup = new SignUpPage(driver);
		
		// Logic
		
		String fname = data.getFname();
		fname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
		signup.fillInFnameTextField(fname);
		if(data.getFname().equalsIgnoreCase(data.getLname())) {
			System.out.println("Fail -- fname: "+data.getFname()+", lname: "+data.getLname());
			org.testng.Assert.fail("Fail: first name equals last name");
		}
		else
		{
			String lname = data.getLname();
			lname = lname.substring(0, 1).toUpperCase() + lname.substring(1);
			signup.fillInLnameTextField(lname);
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
			System.out.println("Fail -- wrong phone format");
			org.testng.Assert.fail("Fail: wrong phone format");
		}
		String email = data.getEmail();
		if(email.contains("@") && email.contains("."))
		{
			//TODO: should not exist before in the saved file
			signup.fillInEmailTextField(data.getEmail());
		}
		else
		{
			System.out.println("Fail -- wrong email format");
			org.testng.Assert.fail("Fail: wrong email format");
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
			System.out.println("Fail -- wrong password format");
			org.testng.Assert.fail("Fail: wrong password format");
		}
		if(data.getPasswd().equals(data.getcPasswd()))
		{
			System.out.println(data.getPasswd());
			System.out.println(data.getcPasswd());
			signup.fillInCPasswdTextField(data.getcPasswd());
		}
		else
		{
			System.out.println("Fail -- password does not match");
			org.testng.Assert.fail("Fail: password does not match");
		}
		signup.clickOnSignUpBtn();
		Thread.sleep(5000);
		String validationLabel = signup.extractTextInDashboard();
		String expectedLabel = "Hi, "+fname;
		if(validationLabel.equals(expectedLabel))
		{
			System.out.println("Validation Passed!");
		}
		else
		{
			System.out.println("Fail -- validation failed or couldn't find web element");
			org.testng.Assert.fail("Fail: validation failed or couldn't find web element");
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
}
