package testgroup.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Abstractcomp;

public class Login extends Abstractcomp {
	WebDriver driver;
	
	public Login (WebDriver driver) {
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
		}

	@FindBy(id="userEmail")
	WebElement emaild;
	@FindBy(id="userPassword")
	WebElement passwordd;
	@FindBy (name="login")
	WebElement lgbtn;
	@FindBy (css="div[aria-label='Incorrect email or password.']")
	WebElement error;
	@FindBy(xpath="//div[contains(text(),'Valid')]")
	WebElement formatError;
	
	public Productcatalogue loggedin(String email,String Passowrd ) {
		emaild.sendKeys(email);
		passwordd.sendKeys(Passowrd);
		lgbtn.click();
		Productcatalogue productcatalogue = new Productcatalogue(driver);
		return productcatalogue;
		
	}
	public void navigate () {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String errormessage() {
		visibilityofelement(error);
		return error.getText();
	}
	public String formaterrormessage() {
		visibilityofelement(formatError);
		return formatError.getText();
	}
}

