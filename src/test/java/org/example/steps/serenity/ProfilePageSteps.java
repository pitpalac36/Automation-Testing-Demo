package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.ProfilePage;
import org.openqa.selenium.WebDriver;

public class ProfilePageSteps {
    ProfilePage page;

    @Step
    public String getDescription() {
        return page.getDescription();
    }
}
