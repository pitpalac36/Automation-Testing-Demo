package org.example.features.search;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.LoginSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/valid_credentials.csv")
public class ValidLoginTest {
    String username;
    String password;

    @Managed(uniqueSession=true)
    private WebDriver webDriver;

    @Steps
    LoginSteps loginSteps;

    @Test
    public void loginTestValid() {
        loginSteps.loginPageOpen();
        loginSteps.login(username, password);
        assert (webDriver.getCurrentUrl().equals("https://moodle.cs.ubbcluj.ro/"));
    }
}
