package stepDefenition;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObject.Homepage;
import pageObject.loginPage;
import resources.base;

public class stepDefenition extends base {
    public static Logger log = LogManager.getLogger(base.class.getName());

    @Given("^User launches the url$")
    public void user_launches_the_url() throws Exception {
        driver = invokebrowser();
        log.info("Driver is initialized for Scn_Login");
        driver.get(prop.getProperty("url"));
        log.info("Browser is launched for Scn_Login");

    }

    @Given("^user provides the required credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_provides_the_required_credentials_and(String uname, String pwd) throws Exception {
        Homepage ele = new Homepage(driver);

        ele.getlogin().click();
//        Scn_Login sc = new Scn_Login();
//        sc.getdata();
        loginPage l = new loginPage(driver);

        l.getemail().sendKeys(uname);
        l.getpwd().sendKeys(pwd);
        log.info("credentials provided");
    }
}
