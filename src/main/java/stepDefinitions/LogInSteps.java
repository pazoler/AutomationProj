package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import pageObjects.BasePageObject;
import pageObjects.LoginPO;


public class LogInSteps extends BasePageObject {
    private LoginPO loginPO;

    public LogInSteps(LoginPO loginPO) {
        this.loginPO = loginPO;
    }


    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
       loginPO.navigateToLoginPage();
    }


    @When("I enter a username {}")
    public void i_enter_a_username(String username) {
        loginPO.setUsernameTextField(username);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {

       loginPO.setPasswordTextField(password);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {

        loginPO.clickLogInButton();
    }

    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() {
      loginPO.validateSuccessLoginMessage();
    }

    @Then("I should be presented with the unsuccessful login message")
    public void i_should_be_presented_with_the_unsuccessful_login_message() {
        loginPO.validateUnSuccessLoginMessage();
    }

    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) {
        getTextFromAlert(expectedMessage);
    }
}
