package testgroup.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.Abstractcomp;

public class CartPage extends Abstractcomp {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li/button[@class='btn btn-primary']")
	WebElement checkout;

	@FindBy(className = "cartWrap")
	List<WebElement> allAdded;

	public Boolean verifyAddedItems(String productName) {
		return allAdded.stream()
				.anyMatch(c -> c.findElement(By.tagName("h3")).getText().equalsIgnoreCase(productName));
	}

	public Checkout checkOut() {
		checkout.click();
		Checkout checkout = new Checkout(driver);
		return checkout;
	}
}
