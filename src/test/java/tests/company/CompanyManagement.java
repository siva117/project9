package tests.company;

import java.io.IOException;
import java.util.HashMap;

import com.aventstack.extentreports.Status;

import exceptions.FieldInDataFileNotFoundException;
import framework.DataUtil;
import framework.Driver;
import framework.EventMethods;
import framework.GlobalVariables;
import framework.ReporterUtil;
import pages.ICreateCompanyPage;
import pages.IHomePage;
import pages.ILoginPage;
import pages.impl.CreateCompanyPage;
import pages.impl.HomePage;
import pages.impl.LoginPage;

public class CompanyManagement  extends EventMethods{

	public static void main(String[] args) throws Exception {
		
		
		CC001_createNewCompany_public();

	}
	
	
	public static void CC001_createNewCompany_public() throws IOException, FieldInDataFileNotFoundException {
		ReporterUtil reportUtil = new ReporterUtil();
		DataUtil dt = new DataUtil();
		
		reportUtil.initializeReport("RegressionExecution", "Regression");
		
		reportUtil.createTest("createNewCompany_public");
		
		HashMap <String,String> execConfig = dt.getPropertiesData(GlobalVariables.EXECUTION_CONFIG_FILE);
		HashMap <String,String> envInfo  =dt.getPropertiesData(dt.getEnvConfigFile(execConfig.get("env")));
		HashMap<String, String> tcData = dt.getTCData(GlobalVariables.DATA_FILES_PATH + "CompanyManagement.xlsx", "CreateCompany", "CC001");
		
		Driver.createInstace(execConfig.get("browser"), envInfo.get("url"));
		
		ILoginPage loginPage = new LoginPage(Driver.get());
		IHomePage homePage = new HomePage(Driver.get());
		ICreateCompanyPage createCompanyPage = new CreateCompanyPage(Driver.get());
		
		try {
			if (loginPage.isLoginPageDisplayed()) {
				reportUtil.writeLog(Status.PASS, "Application is launched sucessfully.");
			} else {
				reportUtil.writeLog(Status.FAIL, "Application is not launched", "LaunchApp");
				throw new Exception("Login page is not displayed.");
			}
			
			boolean isLoginSuccess = loginPage.login(envInfo.get("username"), envInfo.get("password"));
			
			if (isLoginSuccess) {
				reportUtil.writeLog(Status.PASS, "Successfully logged in.", "Loginpage");
			} else {
				reportUtil.writeLog(Status.FAIL, "Failed to Login.", "Loginpage");
			}
			
			constantWait(5000);
			boolean isNavigatedToCompaniesPage = homePage.navigateToCompaniesPage();
			if (isNavigatedToCompaniesPage) {
				reportUtil.writeLog(Status.PASS, "Successfully navigated to Companies Page");
			} else {
				reportUtil.writeLog(Status.FAIL, "Application is not navigated to Companies page", "companiesPage");
				throw new Exception("Failed to navigate to Companies Page");
			}
			constantWait(5000);
			boolean isNavigateToCreateCompanyPage = createCompanyPage.navigateToCreateCompanyPage();
			if (isNavigateToCreateCompanyPage) {
				reportUtil.writeLog(Status.PASS, "Successfully navigated to new Company Page");
			} else {
				reportUtil.writeLog(Status.FAIL, "Application is not navigated to new company page", "companiesPage");
				throw new Exception("Failed to navigate to New Company Page");
			}
			
			constantWait(3000);
			createCompanyPage.enterCompanyName(tcData.get("COMPANY_NAME"));
			createCompanyPage.selectCompanyAccessibility(tcData.get("ACCESS"));
			createCompanyPage.selectStatus(tcData.get("STATUS"));
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
		//	Driver.quitDriver();
			reportUtil.finalizeReport();
		}
		
		
		
		
		
		
		
		
	}

}
