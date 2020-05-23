package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.Homepage;
import resources.base;

import javax.sql.rowset.BaseRowSet;
import java.io.File;
import java.io.IOException;


public class Verify_Title extends base {
    public static Logger log = LogManager.getLogger(base.class.getName());
    @BeforeTest
    public void initialize() throws IOException {
        driver = invokebrowser();
        log.info("Driver is initialized for Verify_Title");
        driver.get(prop.getProperty("url"));
        log.info("Browser is launched for Verify_Title");

    }

    @Test
    public void title() throws IOException {


        Homepage ele = new Homepage(driver);
        String abc = ele.gettitle().getText();
        Assert.assertEquals(abc,"FEATURED12 COURSES");
        log.info("Verified the assert statement");
        Assert.assertTrue(ele.getnavbar().isDisplayed());
        log.info("Navigation bar is displayed");


    }

    @AfterTest
    public void closebrowser(){
        driver.quit();
        driver = null;
        log.info("Browser is closed for Verify_Title");
    }


}
