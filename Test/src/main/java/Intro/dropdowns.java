package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdowns {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//		Select dropdown = new Select (driver.findElement(By.cssSelector("Select[id*='DropDownListCurrency']")));
//		dropdown.selectByVisibleText("AED");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id*='originStation1']")).click();
		driver.findElement(By.cssSelector("a[value='VTZ']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='HYD']")).click();
	}

}
