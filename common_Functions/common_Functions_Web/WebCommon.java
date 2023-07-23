package common_Functions_Web;

import org.openqa.selenium.WebElement;

public class WebCommon {

	public static boolean isPresent(WebElement ele) {
		boolean res = false;
		if(ele.isDisplayed()) {
			return true;
		}
		return res;
	}
	
	public static boolean isEnabled(WebElement ele) {
		boolean res = false;
		if(isPresent(ele)) {
			if(ele.isDisplayed()) {
				return true;
			}
		}	
		return res;
	}
	
}
