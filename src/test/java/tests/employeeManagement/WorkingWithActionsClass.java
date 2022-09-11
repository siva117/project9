package tests.employeeManagement;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import framework.Driver;

public class WorkingWithActionsClass {

	public static void main(String[] args) throws InterruptedException {
		Driver.createInstace("chrome", "file:///E:/51/HtmlFiles/ListBoxItems.html");
		
		Driver.get().manage().window().maximize();
		
		WebElement opt1 = Driver.get().findElement(By.xpath("//option[text()='India']"));
		WebElement opt2 = Driver.get().findElement(By.xpath("//option[text()='England']"));
		WebElement opt3 = Driver.get().findElement(By.xpath("//option[text()='Australia']"));
		
		Actions act = new Actions(Driver.get());
		
		act.click(opt1).keyDown(Keys.CONTROL).click(opt2).click(opt3).keyUp(Keys.CONTROL).build().perform();
		
		/*
		Driver.get().findElement(By.id("BestPlayer")).click();
		
		Thread.sleep(1000);
		
		Actions act = new Actions(Driver.get());
		
		act.keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(1000);
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(1000);
		Driver.get().findElement(By.id("SecondBest")).click();
		
		Thread.sleep(1000);
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).build().perform();
		*/
		/*Driver.createInstace("chrome", "https://park.glitch.me/");
		
	   WebElement srcElem =	Driver.get().findElement(By.xpath("//img[@alt='bicycle']"));
	   Driver.get().manage().window().maximize();
	 
	   WebElement destElem =  Driver.get().findElement(By.xpath("(//span[@class='dashing'])[4]"));
	    Thread.sleep(10000);
	    Actions act = new Actions(Driver.get());
	    
	    WebElement elem =  Driver.get().findElement(By.xpath("//img[@alt='fire truck']"));
	    
	    act.contextClick(elem).perform(); */
	    
	  //  act.clickAndHold(srcElem).moveToElement(destElem).release(srcElem).build().perform();
	    
	   // act.dragAndDrop(srcElem, destElem).perform();
		
		/*Driver.createInstace("chrome", "https://www.amazon.in/");
		
		WebElement elem =  Driver.get().findElement(By.xpath("//span[text()='Prime']/.."));
		
		Actions act = new Actions(Driver.get());
		
		
		
		act.moveToElement(elem).perform();
		*/
	}

}
