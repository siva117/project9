package exceptions;

public class FieldInDataFileNotFoundException extends Exception {
	private String message;
	
	public FieldInDataFileNotFoundException() {
		
	}
	
	public FieldInDataFileNotFoundException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
