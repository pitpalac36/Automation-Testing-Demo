package org.example.steps.serenity;
import net.thucydides.core.annotations.Step;
import org.example.pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    @Step
    public void loginPageOpen() {
        loginPage.open();
    }

    @Step
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Step
    public void typeUser(String username) {
        loginPage.typeUser(username);
    }

    public void typePassword(String password) {
        loginPage.typePassword(password);
    }

    @Step
    public void login(String username, String password) {
        typeUser(username);
        typePassword(password);
        clickLoginButton();
    }

    public boolean hasFailedLoginAlert() {
        return loginPage.hasFailedLoginAlert();
    }
}
