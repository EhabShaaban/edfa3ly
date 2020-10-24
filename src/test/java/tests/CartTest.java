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

import data.UrlData;
import pages.CartPage;
import utils.ExcelDataConfig;
import utils.StringSlicing;

public class CartTest {
	WebDriver driver;
	
	@Test(dataProvider="UrlData")
	public void test(UrlData data) throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/ehab/tdd-automation-framework/src/test/java/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.edfa3ly.com/cart");
		
		CartPage cart = new CartPage(driver);
		
		cart.fillInUrlTextBox(data.getUrl());
				
		/**
		  	this.takeSnapShot(driver, "/home/ehab/eclipse-workspace/tdd-automation-framework/test-output/snapshots/wrong_password_format_failure_"+dateFormat.format(date)+".png");
			org.testng.Assert.fail("FAIL: WRONG PASSWORD FORMAT");
		**/
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("Test Completed");
	}
	
	@DataProvider(name="UrlData")
	public UrlData[] passData(){
		ExcelDataConfig config = new ExcelDataConfig("/home/ehab/tdd-automation-framework/src/test/java/data/url.xlsx");
		int rows = config.getRowCount(0);
		UrlData[] data = new UrlData[rows];
		for(int i=0; i<rows; i++) {
			UrlData urlData = new UrlData();
			urlData.setUrl(config.getData(0, i, 0));
			data[i]=urlData;
		}
		return data;
	}
}
