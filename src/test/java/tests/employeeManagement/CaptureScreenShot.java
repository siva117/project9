package tests.employeeManagement;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import framework.Driver;

public class CaptureScreenShot {

	public static void main(String[] args) throws IOException {
		
		Driver.createInstace("chrome", "file:///E:/51/HtmlFiles/ListBoxItems.html");
		
		Driver.get().manage().window().maximize();
		
		TakesScreenshot ts = (TakesScreenshot) Driver.get();
		String str = ts.getScreenshotAs(OutputType.BASE64);
		System.out.println(str);
		File img =   ts.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir") + "\\screenShots\\SampleScreenShot.png");
		
		Files.move(img, dest);
		
		

	}

}
