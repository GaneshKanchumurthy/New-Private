package Intro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Rte {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts()
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		int lCount = driver.findElements(By.tagName("a")).size();
//		System.out.println(driver.findElements(By.tagName("a")).size());
//		System.out.println(lCount);
//		System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size());
		WebElement element = driver.findElement(By.xpath("//ul"));
//		System.out.println(element.findElements(By.tagName("a")).size());
		List<WebElement> total = element.findElements(By.tagName("a"));
		System.out.println(total.size());
		for (WebElement totallinks: total ) {
			Actions a = new Actions(driver);
			a.moveToElement(totallinks).keyDown(Keys.CONTROL).click().build().perform();				
			}
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		it.next();
		for (int i=0; i<total.size();i++) {
			String arg = it.next();
			System.out.println(driver.switchTo().window(arg).getTitle());
		}
				
			
		}
		
//		driver.quit();
		
	}


