package org.example.steps.serenity;
import org.example.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageSteps {
    MainPage mainPage;

    public void typeCourse(String course) {
        mainPage.typeCourse(course);
    }

    public void clickGo() {
        mainPage.clickGo();
    }

    public void clickProfileDropdown() {
        mainPage.clickProfileDropdown();
    }

    public void clickProfilePageButton() {
        mainPage.clickProfilePageButton();
    }

    public void divExistsAndContains(WebDriver driver, String text) {
        mainPage.divExistsAndContains(driver, text);
    }

    public void clickEditProfile(WebDriver driver) {
        mainPage.clickEditProfile(driver);
    }

    public void updateDescription(String text) {
        mainPage.updateDescription(text);
    }

    public void updateProfile() {
        mainPage.updateProfile();
    }

    public boolean descriptionWasUpdated(WebDriver driver) {
        return mainPage.descriptionWasUpdated(driver);
    }
}
