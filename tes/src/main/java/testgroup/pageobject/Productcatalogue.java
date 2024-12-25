package testgroup.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Abstractcomp;

public class Productcatalogue extends Abstractcomp {
	WebDriver driver;

	public Productcatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(className = "col-lg-4")
	List<WebElement> products;
	By loc = By.className("col-lg-4");
	By toast = By.cssSelector("#toast-container");
	@FindBy(css = ".ng-animating")
	WebElement animation;

	public List<WebElement> products() {
		visibilityWait(loc);
		return products;

	}

	public void getproduct(String productName) {
		products.stream().filter(p -> p.findElement(By.tagName("b")).getText().equals(productName))
				.map(p -> p.findElement(By.className("fa-shopping-cart"))).forEach(p -> p.click());
		visibilityWait(toast);
		invisibilityWait(animation);
	}

}
