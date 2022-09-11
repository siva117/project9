package pages;

public interface ILoginPage {
	
	boolean isLoginPageDisplayed();
	
	boolean login(String userName, String passWord) throws Exception;
	

}
