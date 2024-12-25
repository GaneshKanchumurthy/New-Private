package Intro;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String userName= driver.findElement(By.xpath("//p//i")).getText();
		String password = driver.findElement(By.xpath("(//p//i)[2]")).getText();
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		Select dropdown = new Select(driver.findElement(By.cssSelector("select[data-style='btn-info']")));
		dropdown.selectByVisibleText("Student");
		driver.findElement(By.name("signin")).click();
		addToCart(driver);
		driver.findElement(By.className("btn-primary")).click();
	}


public static void addToCart (WebDriver driver) throws InterruptedException{
	List <WebElement> devices = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
	for (WebElement device: devices) {
		Thread.sleep(3000);
		device.click();
}
}
}