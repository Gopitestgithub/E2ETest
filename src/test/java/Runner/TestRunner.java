package Runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//import io.cucumber.junit.Cucumber;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:\\Nandhu\\E2EProject\\src\\test\\java\\CucumberFeatures",
        glue = "stepDefenition"

)
public class TestRunner extends AbstractTestNGCucumberTests {


}
