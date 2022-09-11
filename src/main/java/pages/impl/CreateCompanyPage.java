package pages.impl;

import org.openqa.selenium.WebDriver;

import exceptions.ValueInListBoxNotFoundException;
import framework.Driver;
import framework.EventMethods;
import pages.ICreateCompanyPage;

public class CreateCompanyPage extends EventMethods implements ICreateCompanyPage {

	private WebDriver driver;
	
	public CreateCompanyPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean navigateToCreateCompanyPage() throws Exception {
		
		clickElement(CreateCompanyElems.btnCreateCompany, 30);
		
		if (getElement(CreateCompanyElems.elemNewCompanyPageHeader, 30) == null) {
			return false;
		} else {
			return true;
		}
		
	}

	
	public void enterCompanyName(String companyName) throws Exception {
		enterValue(CreateCompanyElems.edtCompanyName, companyName);
		
	}

	
	public void selectCompanyAccessibility(String access) throws Exception {
		
		String currentAccess = getElement(CreateCompanyElems.btnAccess, 10).getText();
		
		if (!currentAccess.trim().equalsIgnoreCase(access.trim()))
				clickElement(CreateCompanyElems.btnAccess, 0);
		
		
	}

	
	public void selectStatus(String status) throws ValueInListBoxNotFoundException {
		
		selectValueFromList(CreateCompanyElems.lstStatus, status);
		
	}

	@Override
	public void enterAddress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveCompany() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectPriority(String priority) {
		// TODO Auto-generated method stub
		
	}
	
	

}
