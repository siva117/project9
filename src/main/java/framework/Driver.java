package framework;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	private static WebDriver driver;
	private static String mainWindowHandle;
	
	private Driver() {
		
	}
	
	public static void createInstace(String browser, String url) {
		if (driver == null) {
		
			switch (browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
				
			default:
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;		
			}
			
			driver.get(url);
			
			driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_TIME_OUT, GlobalVariables.IMPLICIT_TIME_UNIT);
			driver.manage().window().maximize();
			
			mainWindowHandle = driver.getWindowHandle();
		}
		
	}
	
	public static WebDriver get() {
		return driver;
	}
	
	public void switchToChildWindow(String windowTitle) throws Exception {
		boolean isWindowFound = false;
		Set<String> allHandles = driver.getWindowHandles();
		
		for (String handle: allHandles) {
			driver.switchTo().window(handle);
			if (driver.getTitle().toLowerCase().contains(windowTitle.trim().toLowerCase())) {
				isWindowFound = true;
				break;
			}
		}
		
		if (!isWindowFound) {
			throw new Exception("Unable to switch to window : " + windowTitle+ " as the window is not found.");
		}
	}

	public void switchToMainWindow() {
		driver.switchTo().window(mainWindowHandle);
	}
	
	public void closeCurrentWindow() {
		try {
			driver.close();
		} catch (WebDriverException e) {
			System.out.println("Current window is already closed.");
		}
		
	}
	
	public void close_currentWin_switchTo_main() {
		closeCurrentWindow();
		switchToMainWindow();
	}
	
	public static void quitDriver() {
		try {
		 driver.quit();
		} catch(Exception e) {
			System.out.println("Driver is already terminated.");
		}
	}
	
	
	
	
}
