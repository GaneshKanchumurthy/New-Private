package Intro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class streams {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("surya");
		names.add("Ajit");
		names.add("Sumanth");
		names.add("Srinu");
//		names.stream().filter(n -> n.toLowerCase().startsWith("s")).map(n -> n.toUpperCase())
//				.forEach(n -> System.out.println(n));
//		System.out.println(names.stream().anyMatch(n -> n.equalsIgnoreCase("surya")));
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th")).click();
		List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> item = items.stream().map(i -> i.getText()).collect(Collectors.toList());
		List<String> sorted = item.stream().sorted().collect(Collectors.toList());
//		Assert.assertEquals(item, sorted);
		List<String> prices;
		do {
			items = driver.findElements(By.xpath("//tr/td[1]"));
			prices = items.stream().filter(s->s.getText().contains("Tomato")).map(s->getPrice(s)).collect(Collectors.toList());
			prices.stream().forEach(s->System.out.println(s));
			if (prices.size()<1){
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
			
		}while (prices.size()<1);
		
		
	}

	private static String getPrice(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
