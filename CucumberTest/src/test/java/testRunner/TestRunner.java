package testRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", 
				 glue = {"StepDefinition", "src/main/java/general"},
				 tags = "@googleSearchDatatable or @GoogleSearch",
				 dryRun = false,
				 plugin = {"json:target/cucumber.json", "html:target/html-reports/report.html"})

public class TestRunner {

}
