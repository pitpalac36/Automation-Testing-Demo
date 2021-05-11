package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://moodle.cs.ubbcluj.ro/user/profile.php?id=4075")
public class ProfilePage extends PageObject {
    @FindBy(className = "description")
    private WebElement descriptionField;

    public String getDescription() {
        return descriptionField.findElement(By.tagName("p")).getText();
    }
}
