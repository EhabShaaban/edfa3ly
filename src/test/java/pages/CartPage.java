/**
@FindBy(name="firstname")
private WebElement first_name;
first_name.sendKeys(text);
**/

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

public class CartPage {
	
	public WebDriver driver;
	
	By urlTextBox = By.xpath("//input[@name='url']");
	By colorDropDownList = By.name("color");
	//By colorDropDownList = By.xpath("//*[@id=\"cart-basic-box\"]/div[3]/div[5]/div[2]/div/select");
	//By colorValueLabel = By.xpath("//*[contains(text(),'Black Iris')]");
	By sizeDropDownList = By.name("size");
	By addItemBtn = By.xpath("//input[@value='Add item']");
	//By cartDetailsLabel = By.xpath("//*[contains(text(),'Cart Details')]");
	By cartDetailsLabel = By.xpath("//*[contains(text(),'What are you waiting for?')]");
	By errMsgLabel = By.xpath("//*[contains(text(),'we apologize')]");
	
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
			urlTextBoxWebElement.sendKeys("g");
		    return this;
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			 WebElement urlTextBoxWebElement = driver.findElement(urlTextBox);
			 String js = "arguments[0].setAttribute('value','"+text+"')";
			 driver.findElement(urlTextBox).click();
			 ((JavascriptExecutor) driver).executeScript(js, urlTextBoxWebElement);
			 urlTextBoxWebElement.sendKeys("g");
			 return this;
		}
	}

	public CartPage selectColor() {
		Select color = new Select(driver.findElement(colorDropDownList));
        color.selectByVisibleText("Black Iris");
		//WebElement colorDropDownListWebElement = driver.findElement(colorDropDownList);
		//colorDropDownListWebElement.click();
		//WebElement colorValueWebElement = driver.findElement(colorValueLabel);
		//colorValueWebElement.click();
        return this;
	}
	
	public CartPage selectSize() {
		Select color = new Select(driver.findElement(sizeDropDownList));
        color.selectByVisibleText("9.5");
        return this;
	}

	public CartPage clickOnAddItemBtn() {
		WebElement addItemBtnWebElement = driver.findElement(addItemBtn);
		addItemBtnWebElement.click();
        return this;
	}

	public String getErrMsg() {
		return driver.findElement(errMsgLabel).getText();
	}
	
}