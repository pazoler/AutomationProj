package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePageObject {
    private @FindBy(id="text")
    WebElement usernameTextField;

    private @FindBy(id = "password")
    WebElement passwordTextField;

    private @FindBy(id = "login-button")
    WebElement loginButton;

    public LoginPO() {
        super();
    }

    public void navigateToLoginPage () {
        navigateToURL("https://www.webdriveruniversity.com/Login-Portal/index.html?");
    }

    public void setUsernameTextField (String username) {
        sendKeys(usernameTextField, username);
    }

    public void setPasswordTextField (String password) {
        sendKeys(passwordTextField, password);
    }

    public void clickLogInButton() {
        waitForWebElementAndClick(loginButton);
    }

    public void validateSuccessLoginMessage() {
        getTextFromAlert("validation succeeded");
    }

    public void validateUnSuccessLoginMessage() {
        getTextFromAlert("validation failed");
    }

}
