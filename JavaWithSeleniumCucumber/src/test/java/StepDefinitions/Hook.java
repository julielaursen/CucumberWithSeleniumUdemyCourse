package StepDefinitions;

import org.openqa.selenium.firefox.FirefoxDriver;

import Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.Scenario;

public class Hook extends BaseUtil{
	
	private BaseUtil base;
	
	//create a constructor for dependency injection
	public Hook(BaseUtil base) {
		this.base = base;
	}

	@Before
	public void InitializeTest(Scenario scenario) {
		System.out.println("Opening the browser: Firefox");
		System.out.println("Starting - " + scenario.getName());
		//Passing a dummy WebDriver instance
		//base.StepInfo = "FirefoxDriver";
		//System.setProperty updated from webdriver.firefox.marionette to webdriver.gecko.driver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\julie.laursen\\eclipse-workspace\\Browser Drivers\\firefox-geckodriver0.19.1\\geckodriver.exe");
		base.Driver = new FirefoxDriver();
	}
	
	@After
	public void TearDownTest(Scenario scenario) {
		//scenario.isFailed works in udemy course, seems to be depricated
		if(scenario.isFailed()) {
			//Take screenshot
			System.out.println(scenario.getName());
		}
		System.out.println("Closing the browser: MOCK");
		System.out.println("Status - " + scenario.getStatus());

	}
}
