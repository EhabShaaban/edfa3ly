package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.SignUpPage;
import utils.ExcelDataConfig;

public class SignUpTest {
	WebDriver driver;
	
	@Test(dataProvider="phptravelsData")
	public void signupTest(String fname, String lname, String phone, String email, String password, String cpassword) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/ehab/eclipse-workspace/phptravels/src/test/java/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.phptravels.net/register");
		
		//SignUpPage signup = new SignUpPage();
		//signup.
		
		driver.findElement(By.name("firstname")).sendKeys(fname);
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmpassword")).sendKeys(cpassword);
		driver.findElement(By.className("form-group")).click();
		
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name="phptravelsData")
	public Object[][] passingData(){
		ExcelDataConfig config = new ExcelDataConfig("/home/ehab/eclipse-workspace/phptravels/src/test/java/data/user_info.xlsx");
		int rows = config.getRowCount(0);
		Object[][] data = new Object[rows][6];
		for(int i=0; i<rows; i++) {
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
			data[i][2] = config.getData(0, i, 2);
			data[i][3] = config.getData(0, i, 3);
			data[i][4] = config.getData(0, i, 4);
			data[i][5] = config.getData(0, i, 5);
		}
		return data;
	}
}
