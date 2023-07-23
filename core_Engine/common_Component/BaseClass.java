package common_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentTest logger;
	public static ExtentReports graphicalReport;
	@BeforeClass
	public void beforeEachClass() {
		System.setProperty("webdriver.chrome.driver","G:\\Automation Testing\\Driver\\ChromeV14\\chromedriver.exe");
//		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		op.addArguments("--disable-notifications");
		driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		graphicalReport = new ExtentReports("C:/Users/Admin/eclipse-workspace/NBAVerification/Reports/yelpRevOps/a.html",true);
		logger = graphicalReport.startTest("MyfirstTest");
		
	}
	@AfterClass
	public void afterEachClass() {
		
		graphicalReport.endTest(logger);
		graphicalReport.flush();
	}
}
