import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddToCart{
	ChromeDriver driver;
	String url="https://www.saucedemo.com/inventory.html";
	
	public AddToCart(ChromeDriver driver){
		this.driver=driver;
	}
	
	public void navigateToHomePage() {
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            this.driver.get(this.url);
        }
    }
	
    public Boolean PerformAddToCartFunctionality(String targetProductName) throws InterruptedException {
        List<WebElement> productNameElements = this.driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));

        for (WebElement productNameElement : productNameElements) {
            String productName = productNameElement.getText();
           // System.out.println("Found product: " + productName);
            if (productName.equals(targetProductName)) {
                // If the product name matches the target, click the corresponding "Add to cart" button
                List<WebElement> addButton = productNameElement.findElements(By.xpath("./parent::a/parent::div/following-sibling::div/button"));
              
                // Check if the "Add to cart" button is found
                if (!addButton.isEmpty()) {
  
                    addButton.get(0).click();
                   
                    // The specific product is added to the cart, you can perform additional actions if needed
                    return true;
                }
            }
        }

        // The target product was not found
        return false;
    }
}