package testgroup.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Abstractcomp;

public class Orderhistorypage extends Abstractcomp {
	WebDriver driver;

	public Orderhistorypage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(this.driver, driver);
	}

	@FindBy (xpath="//td[2]")
	List <WebElement> ordertotal;
	
	public Boolean orderValidation(String productName) {
		return ordertotal.stream().anyMatch(a->a.getText().equals(productName));
	}

}
