package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://moodle.cs.ubbcluj.ro/user/edit.php?id=4075&returnto=profile")
public class EditPage extends PageObject {

    @FindBy(id="id_description_editoreditable")
    private WebElement editorBox;

    @FindBy(id="id_submitbutton")
    private WebElement updateProfileButton;

    public void setEditorBoxText(String text) {
        editorBox.click();
        editorBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
    }

    public void clickUpdateProfileButton() {
        updateProfileButton.click();
    }
}
