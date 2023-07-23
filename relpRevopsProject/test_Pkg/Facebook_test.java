package test_Pkg;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import actions_Pkg.Facebook_PA;
import common_Component.BaseClass;
import common_Component.Reporter;

public class Facebook_test extends BaseClass{

	@Test
	public void facebookLoginTest() throws IOException, InterruptedException {
		Facebook_PA fPa = new Facebook_PA(driver,logger);
		try {
			fPa.fbLogin();
			System.out.println("page title is :---> " +driver.getTitle());
			System.out.println("page url is :---> " +driver.getCurrentUrl());
			logger.log(LogStatus.PASS, "Test passed");
//			logger.log(LogStatus.PASS, logger.addScreenCapture(Reporter.takeScreenshot(driver)) + "passed now");
		}catch(Exception e){
			System.out.println("Exception orrcued : -->"+ e );
			throw e;
		}
		
	}
	@Test
	public void simpleTest() {
		System.out.println("I am here Kailas IN second test");
	}
}
