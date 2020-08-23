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
	By signupBtn = By.className("form-group");
	
	public SignUpPage fillInFnameTextField() {
		
		return this;
	}
}