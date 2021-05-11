package org.example.features.search;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.core.annotation.Order;

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

    @Steps
    EditPageSteps editPageSteps;

    @Steps
    ProfilePageSteps profilePageSteps;

    @Steps
    LogoutSteps logoutSteps;

    @Order(1)
    @Test
    public void testScenario() throws InterruptedException {
        loginSteps.loginPageOpen();
        loginSteps.login(username, password);
        assert (webDriver.getCurrentUrl().equals("https://moodle.cs.ubbcluj.ro/"));
        mainPageSteps.typeCourse("Web");
        mainPageSteps.clickGo();
        assert (webDriver.getCurrentUrl().equals("https://moodle.cs.ubbcluj.ro/course/search.php?q=Web&areaids=core_course-course"));
        mainPageSteps.divExistsAndContains(webDriver, "Web");
        mainPageSteps.clickProfileDropdown();
        mainPageSteps.clickProfilePageButton();
        assert (webDriver.getCurrentUrl().equals("https://moodle.cs.ubbcluj.ro/user/profile.php?id=4075"));

        mainPageSteps.clickEditProfile();
        assert (webDriver.getCurrentUrl().equals("https://moodle.cs.ubbcluj.ro/user/edit.php?id=4075&returnto=profile"));

        long randomNumber = Math.round(Math.random() * 100000.0);
        String description = "HELLO WORLD" + randomNumber;
        editPageSteps.updateDescription(description);
        editPageSteps.updateProfile();
        assert (webDriver.getCurrentUrl().equals("https://moodle.cs.ubbcluj.ro/user/profile.php?id=4075"));
        System.out.println(profilePageSteps.getDescription());
        System.out.println(description);
        assert (profilePageSteps.getDescription().equals(description));

        mainPageSteps.clickProfileDropdown();
        logoutSteps.doLogout();
        assert (logoutSteps.isLoggedOut());
    }
}
