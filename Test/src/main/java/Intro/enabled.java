package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class enabled {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//		driver.findElement(By.cssSelector("input[value='RoundTrip']")).click();
//		if (driver.findElement(By.className("picker-second")).getAttribute("style").contains("0.5")){
//			Assert.assertTrue(true);
//		}
//		else {
//			Assert.assertTrue(false);
//		}
//		

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Ganesh");
		driver.findElement(By.name("email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("pass");
		driver.findElement(By.id("exampleCheck1")).click();
		Select gender = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		driver.findElement(By.className("form-control")).click();
		gender.selectByVisibleText("Male");
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.name("bday")).sendKeys("03022001");
		driver.findElement(By.className("btn")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.className("alert")).getText());
	}
	
}
