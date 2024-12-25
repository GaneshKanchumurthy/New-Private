package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class exercise {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver ();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.name("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption1")).isSelected());
		driver.findElement(By.name("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption1")).isSelected());
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

	}

}
