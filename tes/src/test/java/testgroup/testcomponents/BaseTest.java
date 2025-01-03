package testgroup.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import testgroup.pageobject.Login;
import testgroup.pageobject.Productcatalogue;

public class BaseTest {
	public WebDriver driver;
//	  public ThreadLocal <WebDriver> tsd=new ThreadLocal <WebDriver>();
	public Login login;

	public WebDriver initialize() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\testgroup\\reources\\Global.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		return driver;
	}

	public List<HashMap<String, String>> getDataToMap(String FileName) throws IOException {

		String jsonContent = FileUtils.readFileToString(new File(FileName), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "//reports" + "\\" +testcasename + ".jpg"));
		return System.getProperty("user.dir") + "//reports" +"\\"+ testcasename + ".jpg";
	}

	@BeforeMethod(alwaysRun = true)
	public Login startapp() throws IOException {
		driver = initialize();
		login = new Login(driver);
		login.navigate();
		return login;
	}

	@AfterMethod(alwaysRun = true)
	public void endTest() {
		driver.quit();
	}
}
