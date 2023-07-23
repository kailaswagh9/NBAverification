package common_Functions_Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTextbox {
	
	public static void sendInput(WebElement ele,String value) {
		if(WebCommon.isEnabled(ele)) {
			ele.sendKeys(value);
		}
	}

}
