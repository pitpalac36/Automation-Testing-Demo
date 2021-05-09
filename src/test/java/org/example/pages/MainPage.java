package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://moodle.cs.ubbcluj.ro")
public class MainPage extends PageObject {
    @FindBy(id="shortsearchbox")
    private WebElement courseSearchBox;

    @FindBy(css=".btn-secondary[type=submit]")
    private WebElement goButton;

    @FindBy(css=".usertext")
    private WebElement profileDropdown;

    @FindBy(css=".dropdown-item[aria-labelledby=actionmenuaction-2]")
    private WebElement profilePageButton;

    public void typeCourse(String course) {
        courseSearchBox.sendKeys(course);
    }

    public void clickGo() {
        goButton.click();
    }

    public void clickProfileDropdown() {
        profileDropdown.click();
    }

    public void clickProfilePageButton() {
        profilePageButton.click();
    }
}
