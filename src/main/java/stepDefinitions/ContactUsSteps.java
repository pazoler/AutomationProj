package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BasePageObject;
import pageObjects.ContactUsPO;


public class ContactUsSteps extends BasePageObject {
    private WebDriver driver = getDriver();

    private ContactUsPO contactUsPO;

    public ContactUsSteps (ContactUsPO contactUsPO) {
        this.contactUsPO = contactUsPO;
    }


    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        contactUsPO.navigateToWebDriverUniversityContactUsPage();
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
       contactUsPO.setUniqueFirstName();
    }


    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        contactUsPO.setUniqueLastName();
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
         contactUsPO.setUniqueEmailAddress();
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        contactUsPO.setUniqueComment();
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
       contactUsPO.setSpecificFirstName(firstName);
    }

    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        contactUsPO.setSpecificLastName(lastName);
    }

    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        contactUsPO.setSpecificEmailAddress(email);
    }

    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        contactUsPO.setSpecificComment(comment);
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {

        contactUsPO.clickOnSubmitButton();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Thank You for your Message!");
    }
}
