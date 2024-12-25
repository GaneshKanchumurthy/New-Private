package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testgroup.pageobject.CartPage;
import testgroup.pageobject.Orderhistorypage;

public class Abstractcomp {
	WebDriver driver;
	WebDriverWait wait;
		public Abstractcomp(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
		@FindBy (css="[routerlink='/dashboard/cart']")
		WebElement addToCart;
		@FindBy (css="button[routerlink='/dashboard/myorders']")
		WebElement orderHistory;

		
	public void visibilityWait(By Locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
		}
	public void visibilityofelement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void invisibilityWait (WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void elementToBeClickable(WebElement element) {
		wait.until((ExpectedConditions.elementToBeClickable(element)));
	}
	public CartPage addToCart() {
		addToCart.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	public Orderhistorypage orderhistorypage() {
		elementToBeClickable(orderHistory);
		orderHistory.click();
		Orderhistorypage orderHistoryPage = new Orderhistorypage(driver);
		return orderHistoryPage;
	}
}
