package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class assignment6 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement label2 = driver.findElement(By.xpath("//label[@for='benz']"));
		label2.findElement(By.tagName("input")).click();
		String newvar = label2.getText();
		System.out.println(newvar);
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(newvar);
		driver.findElement(By.id("name")).sendKeys(newvar);
		driver.findElement(By.id("alertbtn")).click();
		Assert.assertTrue(driver.switchTo().alert().getText().contains(newvar));
		
	}

}
