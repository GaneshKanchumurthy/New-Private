package Intro;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class autosuggestive {

	public static void main(String[] args) throws InterruptedException, IOException {
		String c = "ind";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys(c);
		Thread.sleep(2000);
		List<WebElement> country = driver.findElements(By.cssSelector(".ui-menu-item"));
		Actions a = new Actions(driver);
		for (WebElement countries:country) {
			if (countries.getText().contentEquals("India")) {
				a.moveToElement(countries).build().perform();
				break;
			}
			
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File ("C:\\Users\\GaneshK\\Pictures\\screenshot.jpg"));
		
	}

}
