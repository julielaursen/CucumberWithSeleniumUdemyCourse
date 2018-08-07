package StepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseUtil;
import Pages.LoginPage;
import Transformation.EmailTransform;
import Transformation.SalaryCountTransformer;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStep extends BaseUtil {
	
	private BaseUtil base;
	
	public LoginStep(BaseUtil base) {
		this.base = base;
	}
	
	@Given("^I navigate to the login page$")
	public void iNavigateToTheLoginPage() throws Throwable {
		System.out.println("Navigate Login Page");
		base.Driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
	}
	
	@And("^I log into the application$")
	public void i_log_into_the_application() throws Throwable {
		System.out.println("Print to the console.");
	}

	@Given("^I enter following details for login$")
	public void i_enter_following_details_for_login(DataTable loginCredentials) throws Throwable {
		List<List<String>> data = loginCredentials.raw();
		System.out.print("The value is :" + data.get(0).get(0).toString() + "\n");
		System.out.print("The value is :" + data.get(0).get(1).toString() + "\n");
		
		//Create an Arraylist
		List<User> users = new ArrayList<User>();
			users = loginCredentials.asList(User.class);
	
	LoginPage page = new LoginPage(base.Driver);
			
	for (User user: users) {
		//base.Driver.findElement(By.name("UserName")).sendKeys(user.username);
		//base.Driver.findElement(By.name("Password")).sendKeys(user.password);
		page.Login(user.username, user.password);
	   }
 	}


	@Given("^I click the login button$")
	public void i_click_the_login_button() throws Throwable {
		LoginPage page = new LoginPage(base.Driver);
		page.ClickLogin();
		//base.Driver.findElement(By.name("Login")).submit();
		
 	}

	@Then("^I should see the userform page$")
	public void i_should_see_the_userform_page() throws Throwable {
		//From hook, driver is passed to the login step using dependency injection
		//System.out.println("The driver is " + base.StepInfo);
		WebDriverWait wait = new WebDriverWait(base.Driver, 60); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Initial")));
		Assert.assertEquals(base.Driver.findElement(By.name("Initial")).isDisplayed(), true);
	}
	
	@Given("^I enter the users email address as Email:([^\"]*)$")
	public void i_enter_the_users_email_address_as_Email_admin(@Transform(EmailTransform.class) String email) throws Throwable {
		//example of using step argument transformations
	    System.out.println("The Email address is " + email);
	}
	
	@Given("^I verify the county of my salary digits for Rs (\\d+)$")
	public void i_verify_the_county_of_my_salary_digits_for_Rs(@Transform(SalaryCountTransformer.class)int salary) throws Throwable {
	    System.out.println("My salary digits count is :" + salary);
	}


	
	public class User
	{
		public String username;
		public String password;
		
		public User(String userName, String passWord) {
			username = userName;
			password = passWord;
		}
	}
	
	@Given("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String arg1, String arg2) throws Throwable {
 	}

	

}
