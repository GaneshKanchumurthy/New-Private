package Intro;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Addtocart {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String[] items = { "Brocolli", "Cucumber", "Carrot" };
		List<String> listItems = Arrays.asList(items);
		List<WebElement> products = driver.findElements(By.cssSelector("div[class='product']"));
		addToCart(driver,listItems, products);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		Assert.assertEquals(driver.findElement(By.className("promoInfo")).getText(), "Code applied ..!");		;
		
		
	}

public static void addToCart(WebDriver driver,List <String> listItems, List <WebElement> products ) {
	for (WebElement product : products) {
		for (int i=0; i< listItems.size();i++) {
			if (product.findElement(By.className("product-name")).getText().contains(listItems.get(i))) {
				
				product.findElement(By.tagName("button")).click();
				String total = driver.findElement(By.xpath("//header//td/following-sibling::td/following-sibling::td")).getText();
				int value = Integer.valueOf(total);
				System.out.println(i);
				if (listItems.size()==value) {
					break;
				}
			}
		}
		
		
	}
}
}
