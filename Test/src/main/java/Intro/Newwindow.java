package Intro;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Newwindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice");
//		driver.switchTo().newWindow(WindowType.TAB);
//		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File ("C:\\Users\\GaneshK\\Pictures\\new.jpg"));
//		File src1 = (driver.findElement(By.name("name"))).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src1, new File ("C:\\Users\\GaneshK\\Pictures\\new.jpg"));
		System.out.println((driver.findElement(By.name("name"))).getRect().getDimension().getWidth());
		driver.manage().window().maximize();
		System.out.println((driver.findElement(By.name("name"))).getRect().getDimension().getWidth());

		
	}

}
