package StepDefinition;

import general.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends CommonMethods {
	public static Scenario scenario;

	@Before
	public void start(Scenario scenario) {
		this.scenario = scenario;
		System.out.println("IN BEFORE HOOK");
		getDriver();
	}

	public void logMessage(String message) {
		scenario.log(message);
	}

	public void attachScreenshot() {
		scenario.attach(scrnscht(), "image/png", "Added Screenshot");
	}

	@After
	public void closeDriver(Scenario scenario) {
		System.out.println("IN AFTER HOOK");

		// Attach Screenshot
		if (scenario.isFailed()) {
			scenario.log("Scenario is Failed");
			scenario.attach(scrnscht(), "image/png", "Failed Screenshot");
		} else {
			scenario.log("Scenario is Passed");
			scenario.attach(scrnscht(), "image/png", "Added Screenshot");
		}

		closeBrowser();
	}

}
