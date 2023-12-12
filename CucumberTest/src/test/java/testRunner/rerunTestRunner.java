package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="target/failedTC.txt", 
				 glue = {"StepDefinition"},
				 dryRun = false,
				 plugin = {"json:target/cucumberRerun.json"})

public class rerunTestRunner {

}
