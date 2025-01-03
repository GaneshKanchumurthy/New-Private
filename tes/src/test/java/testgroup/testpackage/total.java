package testgroup.testpackage;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import testgroup.pageobject.CartPage;
import testgroup.pageobject.Checkout;
import testgroup.pageobject.Confirmationpage;
import testgroup.pageobject.Login;
import testgroup.pageobject.Orderhistorypage;
import testgroup.pageobject.Productcatalogue;
import testgroup.testcomponents.BaseTest;
import testgroup.testcomponents.Retrytest;

public class total extends BaseTest {

	@Test (dataProvider="getdata", groups = {"data"}, retryAnalyzer= Retrytest.class)
	public void placeOrder(HashMap <String, String> input) throws IOException {

		String country = "India";
		Productcatalogue productcatalogue = login.loggedin(input.get("email"), input.get("password"));
		productcatalogue.products();
		productcatalogue.getproduct(input.get("productName"));
		CartPage cartpage = productcatalogue.addToCart();
		Boolean match = cartpage.verifyAddedItems(input.get("productName"));
		Assert.assertTrue(match);
		Checkout checkout = cartpage.checkOut();
		checkout.shippingAddress(country);
		checkout.countryDropdown();
		checkout.clickOnCountry(country);
		Confirmationpage confirmationpage = checkout.placeOrder();
		Assert.assertTrue(confirmationpage.confirmationmsg());

	}

	@Test(dependsOnMethods = { "placeOrder" }, dataProvider="getdata", groups = {"data"})
	public void checkOrderHistory(HashMap <String, String> input) {
		login.loggedin(input.get("email"), input.get("password"));
		Orderhistorypage orderHistorypage = login.orderhistorypage();
		Assert.assertTrue(orderHistorypage.orderValidation(input.get("productName")));
	}
	
	
	@DataProvider 
	public Object[][] getdata() throws IOException {
	List <HashMap<String, String>>	data= getDataToMap(System.getProperty("user.dir")+"//src//test//java//testgroup//data//Purchaseorder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
	
}
