package org.example.features.search;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.LoginSteps;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@Ignore
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/invalid_credentials.csv")
public class InvalidLoginTest {
    String username;
    String password;

    @Managed(uniqueSession=true)
    private WebDriver webDriver;

    @Steps
    LoginSteps loginSteps;

    @Test
    public void loginTestInvalid() {
        loginSteps.loginPageOpen();
        loginSteps.login(username, password);
        assert (loginSteps.hasFailedLoginAlert());
    }
}
