package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.UrlData;
import pages.CartPage;
import utils.ExcelDataConfig;

public class CartTest {
	WebDriver driver;
	
	@Test(dataProvider="UrlData")
	public void test(UrlData data) throws Exception{
		System.setProperty("webdriver.chrome.driver", "/home/ehab/tdd-automation-framework/src/test/java/drivers/chromedriver");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.edfa3ly.com/cart");
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
		
		CartPage cart = new CartPage(driver);
		
		if(data.getSelector().equalsIgnoreCase("1")) {
			
			// Add automated product
			
			cart.fillInUrlTextBox(data.getUrl());
			cart.selectColor()
				.selectSize()
				.clickOnAddItemBtn();
			Thread.sleep(2000);
		  	utils.Capture.takeSnapShot(driver, "/home/ehab/tdd-automation-framework/test-output/snapshots/Product_Added_"+dateFormat.format(date)+".png");
		}
		else {
			
			// Add prohibited product
			
			cart.fillInUrlTextBox(data.getUrl());
			Thread.sleep(2000);
			org.testng.Assert.assertEquals(cart.getErrMsg(), "we apologize, store is not available at this moment");
			utils.Capture.takeSnapShot(driver, "/home/ehab/tdd-automation-framework/test-output/snapshots/Product_Prohibited_"+dateFormat.format(date)+".png");
			
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("Test ist Fertig");
	}
	
	@DataProvider(name="UrlData")
	public UrlData[] passData(){
		ExcelDataConfig config = new ExcelDataConfig("/home/ehab/tdd-automation-framework/src/test/java/data/url.xlsx");
		int rows = config.getRowCount(0);
		UrlData[] data = new UrlData[rows];
		for(int i=0; i<rows; i++) {
			UrlData urlData = new UrlData();
			urlData.setUrl(config.getData(0, i, 0));
			urlData.setSelector(config.getData(0, i, 1));
			data[i]=urlData;
		}
		return data;
	}
}
