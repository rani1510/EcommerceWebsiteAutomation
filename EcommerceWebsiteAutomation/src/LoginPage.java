
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage{
	ChromeDriver driver;
	String url="https://www.saucedemo.com/";
	
	public LoginPage(ChromeDriver driver){
		this.driver=driver;
	}
	public void navigateToLoginPage() {
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            this.driver.get(this.url);
        }
    }
	
	public boolean PerformLogin(String Username ,String Password) throws InterruptedException{
		WebElement userName=this.driver.findElement(By.id("user-name"));
		userName.sendKeys(Username);
		
		WebElement passWord=this.driver.findElement(By.id("password"));
		passWord.sendKeys(Password);
		
		WebElement loginBtn=this.driver.findElement(By.id("login-button"));
		loginBtn.click();
		return true;
	}
}