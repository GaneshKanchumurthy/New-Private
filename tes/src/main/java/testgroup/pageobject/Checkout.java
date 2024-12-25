package testgroup.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Abstractcomp;

public class Checkout extends Abstractcomp {
	WebDriver driver;

	public Checkout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement shipping;
	@FindBy(className = "list-group-item")
	List<WebElement> countries;
	By autoSuggestions = By.className("list-group-item");
	@FindBy(css= "a.btnn")
	WebElement placeOrder;

	public void shippingAddress(String name) {
		shipping.sendKeys(name);
	}

	public List<WebElement> countryDropdown() {
		visibilityWait(autoSuggestions);
		return countries;
	}
	public void clickOnCountry(String country) {
		countries.stream().filter(a -> a.getText().equals(country)).forEach(a -> a.click());
	}

	public Confirmationpage placeOrder() {
		placeOrder.click();
		Confirmationpage confirmationpage = new Confirmationpage(driver);
		return confirmationpage;
	}
}
