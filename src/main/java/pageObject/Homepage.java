package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class Homepage {

    public WebDriver driver;

    By loginbutton = By.xpath("//span[contains(text(),'Login')]");
    By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
    By navbar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");

    public Homepage(WebDriver driver){
        this.driver= driver;
    }

    public WebElement getlogin(){
        return driver.findElement(loginbutton);
    }
    public WebElement gettitle(){
        return driver.findElement(title);
    }
    public WebElement getnavbar(){
        return driver.findElement(navbar);
    }

}
