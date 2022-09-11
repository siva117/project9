package pages.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.EventMethods;
import pages.ILoginPage;

public class LoginPage extends EventMethods implements ILoginPage{
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public boolean isLoginPageDisplayed() {
		
		if (getElement(By.xpath("//input[@name='email']"), 30) == null) {
			return false;
		} else {
			return true;
		}
		
	}
	
	public boolean login(String userName, String passWord) {
		try {
			enterValue(By.xpath("//input[@name='email']"), userName);
			enterValue(By.xpath("//input[@name='password']"), passWord);
			clickElement(By.xpath("//div[text()='Login']"), 10);
			return true;
		} catch(Exception e) {
			return false;
		}

	}
	

}
