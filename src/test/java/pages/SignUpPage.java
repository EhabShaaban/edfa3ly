/**
@FindBy(name="firstname")
private WebElement first_name;
first_name.sendKeys(text);
**/

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
	
	public WebDriver driver;
	
	By fnameTextField = By.name("firstname");
	By lnameTextField = By.name("lastname");
	By phoneTextField = By.name("phone");
	By emailTextField = By.name("email");
	By passwdTextField = By.name("password");
	By cpasswdTextField = By.name("confirmpassword");
	By signupBtn = By.xpath("//*[@id=\"headersignupform\"]/div[8]/button");
	By dashboardValidationLabel = By.xpath("/html/body/div[2]/div[1]/div[1]/div/div/div[1]/div/div[2]/h3");
	
	
	public SignUpPage(WebDriver driver){
		this.driver = driver;
		}

	public SignUpPage fillInFnameTextField(String text) {
		driver.findElement(fnameTextField).sendKeys(text);
		return this;
	}
	
	public SignUpPage fillInLnameTextField(String text) {
		driver.findElement(lnameTextField).sendKeys(text);
		return this;
	}
	
	public SignUpPage fillInPhoneTextField(String text) {
		driver.findElement(phoneTextField).sendKeys(text);
		return this;
	}
	
	public SignUpPage fillInEmailTextField(String text) {
		driver.findElement(emailTextField).sendKeys(text);
		return this;
	}
	
	public SignUpPage fillInPasswdTextField(String text) {
		driver.findElement(passwdTextField).sendKeys(text);
		return this;
	}
	
	public SignUpPage fillInCPasswdTextField(String text) {
		driver.findElement(cpasswdTextField).sendKeys(text);
		return this;
	}
	
	public SignUpPage clickOnSignUpBtn() {
		driver.findElement(signupBtn).click();
		return this;
	}
	
	public String extractTextInDashboard() {
		return driver.findElement(dashboardValidationLabel).getText();
	}
}