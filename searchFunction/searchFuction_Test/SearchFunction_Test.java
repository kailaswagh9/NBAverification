package searchFuction_Test;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFunction_Test {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void beforeEachClass() {
//		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		op.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(op);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void afterEachClass() {
		if(driver.getTitle().equals("")) {
			driver.close();
		}
	}
		
	@Test(dataProvider = "searchTestData")
	public void searchFunction(String platform, String searchValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		switch(platform) {
		case "fb" : 
			try {
				driver.get("https://www.facebook.com");
				if(driver.getTitle().equals("Facebook – log in or sign up")) {
					driver.findElement(By.id("email")).sendKeys("8600302244");
					driver.findElement(By.id("pass")).sendKeys("Simple99");
					driver.findElement(By.name("login")).click();
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search' and @placeholder='Search Facebook']"))).sendKeys(searchValue);
				driver.findElement(By.xpath("//input[@type='search' and @placeholder='Search Facebook']")).sendKeys(Keys.ENTER);
				driver.switchTo().newWindow(WindowType.TAB);
				break;
			} catch (Exception e) {
				driver.get("https://www.facebook.com");
				if(driver.getTitle().equals("Facebook – log in or sign up")) {
					driver.findElement(By.id("email")).sendKeys("8600302244");
					driver.findElement(By.id("pass")).sendKeys("Simple99");
					driver.findElement(By.name("login")).click();
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search' and @placeholder='Search Facebook']"))).sendKeys(searchValue);
				driver.findElement(By.xpath("//input[@type='search' and @placeholder='Search Facebook']")).sendKeys(Keys.ENTER);
				driver.switchTo().newWindow(WindowType.TAB);
				break;
			}
					
					
		case "google" : driver.get("https://www.google.com");
						
			try {
				WebElement googleSearchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
				googleSearchBox.sendKeys(searchValue);
//				WebElement searchBtn = driver.findElement(By.name("btnK"));
				googleSearchBox.sendKeys(Keys.RETURN);
				driver.switchTo().newWindow(WindowType.TAB);
				break;
			} catch (Exception e) {
				
			}
						
			
		}
	}
	
	@DataProvider
	public String[][] searchTestData() throws InvalidFormatException, IOException {
		XSSFWorkbook workBook;
		XSSFSheet sheet;
		XSSFCell cell;
		XSSFRow row;
		File file = new File("C:/Users/Admin/eclipse-workspace/NBAVerification/TestData/searchFunction/TestData.xlsx");
		workBook = new XSSFWorkbook(file);
		sheet = workBook.getSheet("Sheet1");
		int lastRow = sheet.getPhysicalNumberOfRows();
//		System.out.println(lastRow);
		int lastCol = sheet.getRow(0).getLastCellNum();
//		System.out.println(lastCol);
		String[][] data = new String[lastRow-1][lastCol];
		for(int i=0;i<lastRow-1;i++) {
			for(int j=0;j<lastCol;j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		return data;
	}
	
}
