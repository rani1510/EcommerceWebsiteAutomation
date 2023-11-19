import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage{
	ChromeDriver driver;
	String url="https://www.saucedemo.com/cart.html";
	
	public CheckoutPage(ChromeDriver driver){
		this.driver=driver;
	}
	
	
	
	public void navigateToCartPage() {
		this.driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            this.driver.get(this.url);
        }
    }
	
    public Boolean PerformCheckoutFunctionality(String firstName,String lastName,String zipCode) throws InterruptedException {
    	try {
    		WebElement checkoutBtn=this.driver.findElement(By.id("checkout"));
        	checkoutBtn.click();
        	
        	WebElement firstName_TxtBox=this.driver.findElement(By.id("first-name"));
        	firstName_TxtBox.sendKeys(firstName);
        	
        	WebElement lastName_TxtBox=this.driver.findElement(By.id("last-name"));
        	lastName_TxtBox.sendKeys(lastName);
        	
        	WebElement zipCode_TxtBox=this.driver.findElement(By.id("postal-code"));
        	zipCode_TxtBox.sendKeys(zipCode);
        	
        	Thread.sleep(1000);
        	WebElement continueBtn=this.driver.findElement(By.id("continue"));
        	continueBtn.click();
        	
        	Thread.sleep(1000);
        	WebElement finishBtn=this.driver.findElement(By.id("finish"));
        	finishBtn.click();
        	
        	Thread.sleep(1000);
        	
        	WebElement message=this.driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
        	String textMsg=message.getText();
        	if(textMsg.equals("Thank you for your order!")) {
        		return true;
        	}
        	return false;
    	}
    	catch (Exception e) {
    	    e.printStackTrace();
    	}
    	return false;
    }
}