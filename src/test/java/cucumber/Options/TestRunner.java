package cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/java/features"},
				  glue = {"stepDefinations"},
				monochrome = true,
		        dryRun = false,
		        plugin = {"pretty",
                        "json:target/cucumber-reports/reports.json",
                        "json:target/cucumber-reports/cucumber.runtime.formatter.JSONFormatter"})
		      
public class TestRunner {

}

