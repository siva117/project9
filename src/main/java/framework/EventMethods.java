package framework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import exceptions.ValueInListBoxNotFoundException;

public class EventMethods extends ElementLocators{
	
	
	public static void constantWait(long timeInMillis) {
		
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			
		}
		
	}
	
	public boolean isElementEnabled(WebElement elem, int timeOut) {
		
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), timeOut);
			wait.pollingEvery(Duration.ofMillis(200));
			wait.until(ExpectedConditions.elementToBeClickable(elem));
			return true;
		} catch(Exception e) {
			return false;
		}
	 }
	
	public boolean isElementDisplayed(WebElement elem, int timeOut) {

		
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), timeOut);
			wait.pollingEvery(Duration.ofMillis(200));
			wait.until(ExpectedConditions.visibilityOf(elem));
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
    public WebElement getElement(By by, int timeOut) {

    	WebElement elem = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), timeOut);
			wait.pollingEvery(Duration.ofMillis(200));
			elem = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			return elem;
		} catch(Exception e) {
			return null;
		}
	}

	
	public void clickElement(By by, int timeout) throws Exception {
		WebElement elem = getElement(by, timeout);
		if (elem != null) {
			if (isElementDisplayed(elem, timeout)) {
				if (isElementEnabled(elem, timeout)) {
					elem.click();
				} else {
					throw new Exception("Element : " + by.toString() + " was not clicked as the is not enabled in the application. ");
				}
				
			} else {
				throw new Exception("Element : " + by.toString() + " was not clicked as the is not displayed (invisible) in the application. ");
			}
			
		} else {
			throw new Exception("Element : " + by.toString() + " was not clicked as the elment is not found in the application.");
		}
		
	}
	
	public void clickElement(WebElement elem, int timeout) throws Exception {

			if (isElementDisplayed(elem, timeout)) {
				if (isElementEnabled(elem, timeout)) {
					elem.click();
				} else {
					throw new Exception("Element : " + elem.toString() + " was not clicked as the is not enabled in the application. ");
				}
				
			} else {
				throw new Exception("Element : " + elem.toString() + " was not clicked as the is not displayed (invisible) in the application. ");
			}
	}
	
	
	
	public void selectValueFromList(WebElement listBox, String valueToSelect) throws ValueInListBoxNotFoundException {
		boolean isValueFound = false;
		if (isElementEnabled(listBox, 20)) {
			if (isElementDisplayed(listBox, 20)) {
				List<WebElement> allOptions = listBox.findElements(By.tagName("option"));
				 for (WebElement option: allOptions) {
					 String optText = option.getText();
					 if (optText.trim().equalsIgnoreCase(valueToSelect.trim())) {
						 option.click();
						 isValueFound = true;
						 break;
					 }
				 }
				
				 if (!isValueFound) {
					 throw new ValueInListBoxNotFoundException("given value : '" + valueToSelect+ "' not found in the listbox : " + listBox.toString() );
				 }
			} else {
				 throw new ValueInListBoxNotFoundException("given value : '" + valueToSelect+ "' in the listbox : " + listBox.toString()+" cannot be selected as the listbox is not displayed." );
			}
		
		} else {
			 throw new ValueInListBoxNotFoundException("given value : '" + valueToSelect+ "' in the listbox : " + listBox.toString()+" cannot be selected as the listbox is not enabled." );
		 
		}
				
	}
	
	public void selectValueFromList(By locatorForList, String valueToSelect) throws ValueInListBoxNotFoundException {
		
	   
		boolean isValueFound = false;
		WebElement listBox = getElement(locatorForList, 20);
		if (listBox != null) {
			if (isElementEnabled(listBox, 20)) {
				if (isElementDisplayed(listBox, 20)) {
					listBox.click();
					constantWait(3000);
					List<WebElement> allOptions = listBox.findElements(By.tagName("span"));
					 for (WebElement option: allOptions) {
						 String optText = option.getText();
						 if (optText.trim().equalsIgnoreCase(valueToSelect.trim())) {
							 option.click();
							 isValueFound = true;
							 break;
						 }
					 }
					
					 if (!isValueFound) {
						 throw new ValueInListBoxNotFoundException("given value : '" + valueToSelect+ "' not found in the listbox : " + listBox.toString() );
					 }
				} else {
					 throw new ValueInListBoxNotFoundException("given value : '" + valueToSelect+ "' in the listbox : " + listBox.toString()+" cannot be selected as the listbox is not displayed." );
				}
			
			} else {
				 throw new ValueInListBoxNotFoundException("given value : '" + valueToSelect+ "' in the listbox : " + listBox.toString()+" cannot be selected as the listbox is not enabled." );
			 
			}
		} else {
			 throw new ValueInListBoxNotFoundException("given value : '" + valueToSelect+ "' in the listbox : " + listBox.toString()+" cannot be selected as the listbox is not found in the application." );
		}
	}
		
	
	public void enterValue(By by, String valueToEnter) throws Exception {
		WebElement elem = getElement(by, 20);
		if (elem != null) {
			if (isElementDisplayed(elem, 20)) {
				if (isElementEnabled(elem, 20)) {
					elem.sendKeys(valueToEnter);;
				} else {
					throw new Exception("Unable to enter the value : " + valueToEnter + " in the field : " + by.toString()+ " as the field is not enabled.");
				}
				
			} else {
				throw new Exception("Unable to enter the value : " + valueToEnter + " in the field : " + by.toString()+ " as the field is not displayed (invisible).");
			}
			
		} else {
			throw new Exception("Unable to enter the value : " + valueToEnter + " in the field : " + by.toString()+ " as the element is not found.");
		}
		
	}
	
	
	
	public void selectCheckBox(By by) throws Exception {
		WebElement elem = getElement(by, 20);
		if (elem != null) {
			if (isElementDisplayed(elem, 20)) {
				if (isElementEnabled(elem, 20)) {
					if (!elem.isSelected())
							elem.click();
				} else {
					throw new Exception("Unable to select the checkbox : " + by.toString()+ " is disabled.");
				}
				
			} else {
				throw new Exception("Unable to select the checkbox : " + by.toString()+ " is not displayed in ui (invisible).");
			}
			
		} else {
			throw new Exception("Unable to select the checkbox : " + by.toString()+ " is not found in the application.");
		}
		
	}
	
	public void unSelectCheckBox(By by) throws Exception {
		WebElement elem = getElement(by, 20);
		if (elem != null) {
			if (isElementDisplayed(elem, 20)) {
				if (isElementEnabled(elem, 20)) {
					if (elem.isSelected())
							elem.click();
				} else {
					throw new Exception("Unable to unselect the checkbox : " + by.toString()+ " is disabled.");
				}
				
			} else {
				throw new Exception("Unable to unselect the checkbox : " + by.toString()+ " is not displayed in ui (invisible).");
			}
			
		} else {
			throw new Exception("Unable to unselect the checkbox : " + by.toString()+ " is not found in the application.");
		}
		
	}
	
	public void killProcesses() {
		
		try {
			Runtime.getRuntime().exec("//taskkill /F /IM notepad.exe");
		} catch(Exception e) {
			
		}
		
	}

}
