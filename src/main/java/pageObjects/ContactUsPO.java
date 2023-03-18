package pageObjects;

import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.GlobalVariables;

public class ContactUsPO extends BasePageObject {
    //private @FindBy(how = How.XPATH, using = "//input[@name='first_name']")
    private @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstNameTextField;

    private @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastNameTextField;

    private @FindBy(xpath = "//input[@name='email']")
    WebElement emailAddressTextField;

    private @FindBy(xpath = "//textarea[@name='message']")
    WebElement commentTextField;

    private @FindBy(xpath = "//input[@value='SUBMIT']")
    WebElement submitButton;

    private @FindBy(xpath = "//div[@id='contact_reply']/h1")
    WebElement successfulSubmissionMessageText;

    public ContactUsPO() {
        super();
    }

    public void navigateToWebDriverUniversityContactUsPage() {
        navigateToURL(GlobalVariables.SITE_HOME_PAGE_URL + "/Contact-Us/contactus.html");
    }

    public void setUniqueFirstName() {
        sendKeys(firstNameTextField, "AutoFN" + generateRandomNumber(5));
    }

    public void setUniqueLastName() {
        sendKeys(lastNameTextField, "AutoLN" + generateRandomNumber(5));
    }

    public void setUniqueEmailAddress() {
        sendKeys(emailAddressTextField, "AutoEmail" + generateRandomNumber(10) + "@mail.com");
    }

    public void setUniqueComment() {
        sendKeys(commentTextField, "Hello world " + generateRandomString(20));
    }

    public void setSpecificFirstName(String firstName) {
        sendKeys(firstNameTextField, firstName);
    }

    public void setSpecificLastName(String lastName) {
        sendKeys(lastNameTextField, lastName);
    }

    public void setSpecificEmailAddress(String emailAddress) {
        sendKeys(emailAddressTextField, emailAddress);
    }

    public void setSpecificComment(String comment) {
        sendKeys(commentTextField, comment);
    }

    public void clickOnSubmitButton() {
        waitForWebElementAndClick(submitButton);
    }

    public void validateSuccessfulSubmissionMessageText() {
        waitFor(successfulSubmissionMessageText);
        Assert.assertEquals(successfulSubmissionMessageText.getText(), "Thank You for your Message!");
    }
}
