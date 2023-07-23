package common_Functions_Web;

import org.openqa.selenium.WebElement;

public class WebButton {
	public static void click(WebElement ele) {
		if(WebCommon.isEnabled(ele)) {
			ele.click();
		}
	}
}
