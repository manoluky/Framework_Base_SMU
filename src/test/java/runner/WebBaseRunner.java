package runner;

import definitions.Hooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)
@CucumberOptions(glue = {"definitions"},
                 features = "src/test/java/features",
                 plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                		 ,"json:results/cucumber.json"
                		 ,"junit:results/cucumber.xml"},
		         tags = "@TEST_RA-200",
                 monochrome = true)

public class WebBaseRunner extends Hooks{

}
