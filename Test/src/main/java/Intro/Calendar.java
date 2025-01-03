package Intro;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String year ="2027"; 
		String y="//button[contains(text(),'" +year+ "')]";
		String month = "December";
		String m = "//abbr[contains(text(), '" +month + "')]";
		String date = "20";
		String d = "//abbr[contains(text(),'"+ date + "')]"; 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator <String> it = windows.iterator();
		String parent = it.next();
		
		String child = it.next();
		driver.switchTo().window(child);
		driver.findElement(By.xpath("//button[contains(@class, 'react-date-picker__calendar')]")).click();
		
		driver.findElement(By.xpath("//button/span")).click();
		driver.findElement(By.xpath("//button/span[@class='react-calendar__navigation__label__labelText react-calendar__navigation__label__labelText--from']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(y)));
		driver.findElement(By.xpath(y)).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(m)));
		driver.findElement(By.xpath(m)).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(d)));
		driver.findElement(By.xpath(d)).click();
		
		Thread.sleep(4000);
		driver.quit();
		

	}

}

