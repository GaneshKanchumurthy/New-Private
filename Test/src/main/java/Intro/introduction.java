package Intro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class introduction extends locators2{


	public static void main(String[] args) throws InterruptedException  {
		WebDriver driver = new ChromeDriver();
		String fullPassword = password(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.id("inputUsername")).sendKeys("Ganesh");
		driver.findElement(By.name("inputPassword")).sendKeys("passowrd");
		driver.findElement(By.className("signInBtn")).click();
		String error=driver.findElement(By.cssSelector(".error")).getText();
		System.out.println(error);
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ganesh");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("test");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("3300404444");
		Thread.sleep(1000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		
		driver.findElement(By.className("go-to-login-btn")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Ganesh");
		driver.findElement(By.cssSelector("input[placeholder*='Pass']")).sendKeys(fullPassword);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//input[@value='agreeTerms']")).click();
		driver.findElement(By.className("signInBtn")).click();
		//tagname[contains(@attribute,'value')]
		
		
		
	}

	
	}




