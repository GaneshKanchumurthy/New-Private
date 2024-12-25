package Intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
public class Scrolling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,600)");
		 js.executeScript("document.querySelector('.tableFixHead').scrollTop=100");
		 List<WebElement> sum = driver.findElements(By.cssSelector("td:nth-child(4)"));
		int total = 0;
		 for (int i=0;i<(sum.size()-1);i++) {
			total = total+ Integer.valueOf(sum.get(i).getText());
		}
		 System.out.println(total);
	}

}
