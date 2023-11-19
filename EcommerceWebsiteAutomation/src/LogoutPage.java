import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutPage{
	ChromeDriver driver;
	String url="https://www.saucedemo.com/inventory.html";
	
	public LogoutPage(ChromeDriver driver){
		this.driver=driver;
	}
	public void navigateToLogoutPage() {
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            this.driver.get(this.url);
        }
    }
	
	public boolean PerformLogout() throws InterruptedException{
		WebElement menu=this.driver.findElement(By.id("react-burger-menu-btn"));
		menu.click();
		Thread.sleep(1000);
		WebElement logoutBtn=this.driver.findElement(By.id("logout_sidebar_link"));
		logoutBtn.click();
		
		return true;
	}
}