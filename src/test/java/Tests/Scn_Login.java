package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.Homepage;
import pageObject.loginPage;
import resources.base;

import java.io.IOException;

public class Scn_Login extends base {
    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {



    }

    @Test(dataProvider = "getdata")
    public void login(String uname, String pwd) throws IOException, InterruptedException {

        driver = invokebrowser();
        log.info("Driver is initialized for Scn_Login");
        driver.get(prop.getProperty("url"));
        log.info("Browser is launched for Scn_Login");
        Homepage ele = new Homepage(driver);

        ele.getlogin().click();
//        Scn_Login sc = new Scn_Login();
//        sc.getdata();
        loginPage l = new loginPage(driver);

        l.getemail().sendKeys(uname);
        l.getpwd().sendKeys(pwd);
        log.info("credentials provided");
    }

    @AfterTest
    public void closebrowser(){
        driver.close();
//        driver.quit();
        log.info("Browser is closed for Scn_Login");
        driver = null;
    }



}
