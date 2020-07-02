package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/* 100% test coverage as whole feature file is taken into consideration as per BA req.
 * 
 * create maven project maven-archetype-quickstart

add junit, cucumber-java, cucumber-junit dependencies in pom.xml 

Cucumber Framework terminologies:-
Feature file: Given When Then, define all test cases which needs to be automated.
Step definition file: Automation code, how to automate feature file test cases is written here
Junit TestRunner file: it will trigger all the test cases, to connect all these files we use jum=nit test runner.

create feature file
map feature file to step definition file

*/

public class StepDefinition {

    @Given("^user is on net Banking landing page$")
    public void user_is_on_net_banking_landing_page() throws Throwable {
	     System.out.println("Given user_is_on_net_banking_landing_page executed!");
    }

    @When("^user login to application with user name \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_to_application_with_user_name_something_and_password_something(String strArg1, String strArg2) throws Throwable {
     System.out.println(strArg1 + strArg2 + "when executed!");
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
    	System.out.println("Then home_page_is_populated executed!");
    }

    @Then("^All payments cards \"([^\"]*)\" displayed$")
    public void all_payments_cards_displayed(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("AND executed! with arg1: " + arg1); 
    }

}
