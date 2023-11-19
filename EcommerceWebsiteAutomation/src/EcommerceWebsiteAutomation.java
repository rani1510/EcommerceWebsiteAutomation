
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcommerceWebsiteAutomation{
	
	public static ChromeDriver createDriver() {
        return new ChromeDriver();
    }
	
	 public static void logStatus(String type, String message, String status) {

	        System.out.println(String.format("%s |  %s  |  %s | %s",
	                String.valueOf(java.time.LocalDateTime.now()), type, message, status));
	 }
	 
	 public static Boolean TestCase01(ChromeDriver driver) throws InterruptedException{
		 Boolean status;
	     logStatus("Start TestCase", "Test Case 1: Verify Login functionality", "DONE");
          
	     LoginPage loginPage = new LoginPage(driver);
	     loginPage.navigateToLoginPage();
	     status = loginPage.PerformLogin("standard_user", "secret_sauce");
	     if (!status) {
	            
	            logStatus("End TestCase", "Test Case 1: Verify Login functionality : ", status ? "PASS" : "FAIL");

	            // Return False as the test case Fails
	            return false;
	        } else {
	            logStatus("TestCase 1", "Test Case Pass. Login functionality ", "PASS");
	            return true;
	        }
	     
	     
	 }
	 
	 public static Boolean TestCase02(ChromeDriver driver) throws InterruptedException{
		 Boolean status;
		 logStatus("Start TestCase", "Test Case 02: Applying filter functionality", "DONE");
		 ApplyFilter filter=new ApplyFilter(driver);
		 filter.navigateToHomePage();
		 status=filter.PerformFilterAction();
		 
		 if (!status) {
	            
	            logStatus("End TestCase", "Test Case 2: Applying filter functionality : ", status ? "PASS" : "FAIL");

	            // Return False as the test case Fails
	            return false;
	        } else {
	            logStatus("TestCase 2", "Test Case Pass. Applying filter functionality ", "PASS");
	            return true;
	        }
	 }
	 
	 public static Boolean TestCase03(ChromeDriver driver) throws InterruptedException{
		 Boolean status;
		 logStatus("Start TestCase", "Test Case 03: Add to cart functionality", "DONE");
		 AddToCart cart= new AddToCart(driver);
		 cart.navigateToHomePage();
		 status=cart.PerformAddToCartFunctionality("Sauce Labs Onesie");
		 status=cart.PerformAddToCartFunctionality("Sauce Labs Fleece Jacket");
		 if (!status) {
	            
	            logStatus("End TestCase", "Test Case 03: Add to cart functionality : ", status ? "PASS" : "FAIL");

	            // Return False as the test case Fails
	            return false;
	        } else {
	            logStatus("TestCase 3", "Test Case Pass. Add to cart functionality ", "PASS");
	            return true;
	        }
		 
		 
	 }
	 

	 public static Boolean TestCase04(ChromeDriver driver) throws InterruptedException{
		 Boolean status;
		 logStatus("Start TestCase", "Test Case 04: Checkout functionality", "DONE");
		 CheckoutPage checkout= new CheckoutPage(driver);
		 checkout.navigateToCartPage();
		 status=checkout.PerformCheckoutFunctionality("Chanchal", "Korsewada", "492222");
		 if (!status) {
	            
	            logStatus("End TestCase", "Test Case 04: CheckOut functionality : ", status ? "PASS" : "FAIL");

	            // Return False as the test case Fails
	            return false;
	        } else {
	            logStatus("TestCase 3", "Test Case Pass.CheckOut functionality ", "PASS");
	            return true;
	        }
		 
		 
	 }
	 
	 public static Boolean TestCase05(ChromeDriver driver) throws InterruptedException{
		 Boolean status;
	     logStatus("Start TestCase", "Test Case 05: Verify Logout functionality", "DONE");
          
	     LogoutPage logoutPage = new LogoutPage(driver);
	     logoutPage.navigateToLogoutPage();
	     status=logoutPage.PerformLogout();
	     if (!status) {
	            
	            logStatus("End TestCase", "Test Case 5: Verify Logout functionality : ", status ? "PASS" : "FAIL");

	            // Return False as the test case Fails
	            return false;
	        } else {
	            logStatus("TestCase 5", "Test Case Pass. Logout functionality ", "PASS");
	            return true;
	        }
	     
	 }
	 
	  public static void main(String[] args) throws Exception {
		  Boolean status;
	      ChromeDriver driver =createDriver();
	      status = TestCase01(driver);
	      System.out.println(status);
	      
	      status = TestCase02(driver);
	      System.out.println(status);
	      
	      status = TestCase03(driver);
	      System.out.println(status);
	      
	      status = TestCase04(driver);
	      System.out.println(status);
	      
	      status = TestCase05(driver);
	      System.out.println(status);
	      
	      driver.quit();
	  }
	
}