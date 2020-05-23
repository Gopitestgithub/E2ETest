package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

    public WebDriver driver;

    By email = By.xpath("//input[@type='email']");
    By pwd = By.xpath("//input[@type='password']");

    public loginPage(WebDriver driver){
        this.driver= driver;
    }

    public WebElement getemail(){

        return driver.findElement(email);
    }
    public WebElement getpwd(){

        return driver.findElement(pwd);
    }

}
