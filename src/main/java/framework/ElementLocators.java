package framework;

import org.openqa.selenium.By;

public class ElementLocators {
	
	
	public static class CommonElements{
		
		
	}
	
	public static class LoginPageElems{
		
	}
	
	
	public static class HomePageElems{
		public static final By companiesMenuLink = By.xpath("//span[text()='Companies']");
		public static final By companiesHeaderElem = By.xpath("//div[text()='Companies']");
		
		
	}
	
	public static class CreateCompanyElems{
		
		public static final By btnCreateCompany = By.xpath("//button[text()='Create']");
		public static final By elemNewCompanyPageHeader = By.xpath("//div[text()='Create new Company']");
		public static final By edtCompanyName = By.xpath("//input[@name='name' and @autocomplete='new-password']");
		public static final By btnAccess = By.xpath("//button[text()='Public' or text()='Private']");
		public static final By lstStatus = By.xpath("//div[@name='status' and @role='listbox']");
	}

}
