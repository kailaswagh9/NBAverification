package common_Component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reporter {

	public static String takeScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot takeSS = (TakesScreenshot) driver;
		File source = takeSS.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+ getTime() + ".png");
		FileUtils.copyFile(source, dest);
		String errofl =dest.getAbsolutePath();
		return errofl;
	}
	
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		 sdf.setTimeZone(TimeZone.getTimeZone("IST"));
		 sdf.applyPattern("yyyy_MM_dd_hh_mm_ss");
		return sdf.format(Calendar.getInstance().getTime());
		
	}
}
