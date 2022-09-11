package framework;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;

public class ReporterUtil {
	private ExtentReports reports;
	private ExtentTest testCase; 
	public String captureScreenShot(String imageName) throws IOException {
		String imagePath = GlobalVariables.SCREENSHOT_PATH+imageName+"_"+Utilities.getTimeStamp()+".png";
		
		TakesScreenshot ts = (TakesScreenshot) Driver.get();
		File srcImage = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(imagePath);
		String imageBase64 = ts.getScreenshotAs(OutputType.BASE64);
		
		Files.move(srcImage, dest);
		
		return imageBase64;
	}
	
	
	public void initializeReport(String reportFileName, String suiteName) {
		String reportFilePath = GlobalVariables.REPORTS_PATH+reportFileName+"_"+Utilities.getTimeStamp()+".html";
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFilePath);
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setDocumentTitle("Execution results for : " + suiteName);
			
		 reports = new ExtentReports();
		 reports.attachReporter(sparkReporter);
		 reports.setSystemInfo("UserName", System.getProperty("user.name"));
		
	}
	
	public void createTest(String testName) {
		testCase =  reports.createTest(testName);
	}

	
	public void writeLog(Status status, String stepInfo) {
		testCase.log(status, stepInfo);
	}
	
	public void writeLog(Status status, String stepInfo, String screenShotName) throws IOException {
		testCase.log(status, stepInfo, MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreenShot(screenShotName)).build());
	}
	
	public void finalizeReport() {
		reports.flush();
	}
	
}
