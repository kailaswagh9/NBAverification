package actions_Pkg;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import common_Component.Reporter;
import common_Functions_Web.WebButton;
import common_Functions_Web.WebTextbox;
import common_Functions_Web.WebWait;
import locators_pkg.Facebook_PL;

public class Facebook_PA {
	WebDriver driver = null;
	Facebook_PL fPl = null;
	ExtentTest logger;
	public Facebook_PA(WebDriver driver, ExtentTest logger){
		this.driver = driver;
		this.logger = logger;
		fPl = new Facebook_PL(driver);
	}
	
	@Test
	public void fbLogin() throws IOException, InterruptedException {
		
		WebTextbox.sendInput(fPl.getUsername(), "8600302244");
		WebTextbox.sendInput(fPl.getPassword(), "Simple99");
		WebButton.click(fPl.getFbLoginButton());
//		WebWait.titleIs(driver, "Facebook");
//		WebWait.titleContains(driver, "Facebookpp");
//		Thread.sleep(10000);
//		WebWait.elementToBeClickable(driver, By.xpath("//input[@type='search' and @placeholder='Search Facebook']"));
		
		WebTextbox.sendInput(fPl.getFbSearchBtn(),"Awesome flavor");
		//logger.log(LogStatus.PASS, logger.addScreenCapture(Reporter.takeScreenshot(driver)) +"test passed");
		
	 
		
	}
	
}
