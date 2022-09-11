package exceptions;

import org.openqa.selenium.WebDriverException;

public class ValueInListBoxNotFoundException extends Exception {
	private String message;
	
	public ValueInListBoxNotFoundException() {
		
	}
	
	public ValueInListBoxNotFoundException(String message) {
		this.message = message;
	}

	
	public String getMessage() {
		return message;
	}
}
