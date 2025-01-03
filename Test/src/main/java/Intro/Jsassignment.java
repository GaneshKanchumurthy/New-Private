package Intro;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jsassignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		System.out.println(driver.findElements(By.xpath("//table[@class='table-display'] //tr")).size());
		System.out.println(driver.findElements(By.xpath("//table[@class='table-display'] //th")).size());
		
		for (int i=1; i<4; i++) {
			System.out.println(driver.findElement(By.cssSelector("tr:nth-child(3) td:nth-child("+i+")")).getText());
		}
	}

}
