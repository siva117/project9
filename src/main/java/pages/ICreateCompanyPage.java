package pages;

import exceptions.ValueInListBoxNotFoundException;

public interface ICreateCompanyPage {
	
	boolean navigateToCreateCompanyPage() throws Exception;
	
	void enterCompanyName(String companyName) throws Exception;
	
	void selectCompanyAccessibility(String access) throws Exception;
	
	void selectStatus(String status) throws ValueInListBoxNotFoundException ;
	
	void enterAddress();
	
	void saveCompany();
	
	void selectPriority(String priority);
	
	
	

}
