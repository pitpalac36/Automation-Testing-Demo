package org.example.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://moodle.cs.ubbcluj.ro/login/")
public class LoginPage extends PageObject {

    @FindBy(id="username")
    private WebElement userInput;

    @FindBy(id="loginbtn")
    private WebElement loginButton;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(css=".alert-danger")
    private WebElement alert;


    public void typeUser(String username) {
        userInput.sendKeys(username);
    }

    public void typePassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean hasFailedLoginAlert() {
        return alert != null && alert.getText().equals("Invalid login, please try again");
    }
}
