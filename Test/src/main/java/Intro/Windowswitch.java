package Intro;

import java.awt.Window;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowswitch {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.className("blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iteration = windows.iterator();
		String main =iteration.next();
		String sub = iteration.next();
		driver.switchTo().window(sub);
		String userName = userName (driver);
		driver.switchTo().window(main);
		
		
		
	}


public static String userName(WebDriver driver){
	String user = driver.findElement(By.partialLinkText("mentor@")).getText();
	return user;
}
}
