package pages.impl;

import org.openqa.selenium.WebDriver;

import framework.EventMethods;
import pages.IHomePage;

public class HomePage extends EventMethods implements IHomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	
	public boolean navigateToCompaniesPage() throws Exception {
		
		clickElement(HomePageElems.companiesMenuLink, 30);
		
		if (getElement(HomePageElems.companiesHeaderElem, 20) == null) {
			return false;
		} else {
			return true;
		}
		
		
	}
	
	

}
