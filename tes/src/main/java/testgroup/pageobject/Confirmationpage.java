package testgroup.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Abstractcomp;

public class Confirmationpage extends Abstractcomp {
	WebDriver driver;

	public Confirmationpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By thankyou = By.className("hero-primary");
	@FindBy(className = "hero-primary")
	WebElement confirmationmsg;

	public boolean confirmationmsg() {
		visibilityWait(thankyou);
		return confirmationmsg.getText().equals("THANKYOU FOR THE ORDER.");

	}
}
