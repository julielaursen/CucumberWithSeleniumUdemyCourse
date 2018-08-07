package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class Java8VersionStub implements En{

	public Java8VersionStub() {
 		And("^I just need to see how the step looks for Cucumber-Java(\\d+)$", (Integer arg0) ->  {
			System.out.println("The Value from the new step class is " + arg0);
		});
	}
}
