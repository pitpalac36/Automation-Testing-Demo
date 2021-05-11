package org.example.features.search;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.LoginSteps;
import org.example.steps.serenity.MainPageSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/valid_credentials.csv")
public class ValidScenarioTest {
    String username;
    String password;

    @Managed(uniqueSession=true)
    private WebDriver webDriver;

    @Steps
    LoginSteps loginSteps;

    @Steps
    MainPageSteps mainPageSteps;

    @Test
    public void testScenario() {
        loginSteps.loginPageOpen();
        loginSteps.login(username, password);
        assert (webDriver.getCurrentUrl().equals("https://moodle.cs.ubbcluj.ro/"));
        mainPageSteps.typeCourse("Web");
        mainPageSteps.clickGo();
        assert (webDriver.getCurrentUrl().equals("https://moodle.cs.ubbcluj.ro/course/search.php?q=Web&areaids=core_course-course"));
        mainPageSteps.divExistsAndContains(webDriver, "Web");
        mainPageSteps.clickProfileDropdown();
        mainPageSteps.clickProfilePageButton();
        mainPageSteps.clickEditProfile(webDriver);
    }
}
