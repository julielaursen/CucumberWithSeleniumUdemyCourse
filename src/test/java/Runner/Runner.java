package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

public class Runner {

	@RunWith(Cucumber.class)
	@CucumberOptions(
			plugin = {"pretty", "json:target/cucumber.json"},
			features = {"src/test/resources/Features"},
			glue = {"StepDefinitions"},
			//tags = {"@OfferManagement" },
			monochrome = true
			)

	public class RunCukesTest {

	}

}
