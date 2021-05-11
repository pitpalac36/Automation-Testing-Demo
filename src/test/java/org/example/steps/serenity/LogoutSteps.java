package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pages.MainPage;
import org.openqa.selenium.NoAlertPresentException;

public class LogoutSteps {
    MainPage page;

    @Step
    public void clickProfileDropdown() {
        page.clickProfileDropdown();
    }

    @Step
    public void doLogout() {
        page.clickLogoutButton();
        try {
            page.getAlert().accept();
        } catch (NoAlertPresentException e) {
            ;
        }
    }

    @Step
    public boolean isLoggedOut() {
        return page.isLoggedOut();
    }
}
