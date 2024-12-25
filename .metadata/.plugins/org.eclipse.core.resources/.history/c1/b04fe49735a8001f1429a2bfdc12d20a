package testgroup.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import testgroup.pageobject.Login;
import testgroup.pageobject.Productcatalogue;

public class BaseTest {
	  public WebDriver driver;
//	  public ThreadLocal <WebDriver> tsd=new ThreadLocal <WebDriver>();
	 public Login login;
	public  WebDriver initialize() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\testgroup\\reources\\Global.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("edge")) {
			 driver = new EdgeDriver();
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		return driver;
}
	  @BeforeMethod (alwaysRun=true)
	public Login startapp() throws IOException {
		driver = initialize();
		login = new Login(driver);
		 login.navigate();
		 return login;	
	}
	  @AfterMethod (alwaysRun=true)
	  public void endTest() {
		  driver.quit();
	  }
}
