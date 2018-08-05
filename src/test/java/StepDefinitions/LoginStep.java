package StepDefinitions;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStep {
	
	@Given("^I log into the application$")
	public void i_log_into_the_application() throws Throwable {
		System.out.println("Print to the console.");
	}

	@Given("^I enter following details for login$")
	public void i_enter_following_details_for_login(DataTable loginCredentials) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<List<String>> data = loginCredentials.raw();
		System.out.print("The value is :" + data.get(0).get(0).toString() + "\n");
		System.out.print("The value is :" + data.get(0).get(1).toString() + "\n");
		
		//Create an Arraylist
		List<User> users = new ArrayList<User>();
			users = loginCredentials.asList(User.class);
			
	for (User user: users) {
		System.out.println("The username is " + user.username);
			System.out.println("The Password is " + user.password);
	   }
 	}


	@Given("^I click the login button$")
	public void i_click_the_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("I click the login button");
 	}

	@Then("^I should see the userform page$")
	public void i_should_see_the_userform_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("I should see userform page");
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
	
	

}
