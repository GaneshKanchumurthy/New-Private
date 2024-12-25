package Intro;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignmentmultiplewindows {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iteration = windows.iterator();
		String main = iteration.next();
		String sub = iteration.next();
		driver.switchTo().window(sub);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']")).getText());
		driver.switchTo().window(main);
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		
	}

}
