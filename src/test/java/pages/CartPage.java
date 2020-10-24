/**
@FindBy(name="firstname")
private WebElement first_name;
first_name.sendKeys(text);
**/

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class CartPage {
	
	public WebDriver driver;
	
	By urlTextBox = By.xpath("//input[@name='url']");
	
	public CartPage(WebDriver driver){
		this.driver = driver;
		}
	
	public CartPage fillInUrlTextBox(String text) {
		/**
		driver.findElement(urlTextBox).sendKeys(text);
		WebElement urlTextBoxElement = driver.findElement(urlTextBox);
		String js = "arguments[0].setAttribute('value','"+text+"')";
		driver.findElement(urlTextBox).click();
		((JavascriptExecutor) driver).executeScript(js, urlTextBoxElement);
		return this;
		**/
		try {
		    WebElement urlTextBoxWebElement = driver.findElement(urlTextBox);
		    String js = "arguments[0].setAttribute('value','"+text+"')";
			driver.findElement(urlTextBox).click();
			((JavascriptExecutor) driver).executeScript(js, urlTextBoxWebElement);
		    return this;
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			 WebElement urlTextBoxWebElement = driver.findElement(urlTextBox);
			 String js = "arguments[0].setAttribute('value','"+text+"')";
			 driver.findElement(urlTextBox).click();
			 ((JavascriptExecutor) driver).executeScript(js, urlTextBoxWebElement);
			 return this;
		}
	}

/**
 * 
 * 	public CartPage fillInCPasswdTextField(String text) {
		driver.findElement(cpasswdTextField).sendKeys(text);
		return this;
	}
	
	public CartPage clickOnSignUpBtn() {
		driver.findElement(signupBtn).click();
		return this;
	}
	
	public String extractTextInDashboard() {
		return driver.findElement(dashboardValidationLabel).getText();
	}
 */
}