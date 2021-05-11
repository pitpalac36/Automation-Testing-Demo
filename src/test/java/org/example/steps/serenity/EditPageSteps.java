package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.EditPage;

public class EditPageSteps {
    private EditPage page;

    @Step
    public void updateDescription(String text) {
        page.setEditorBoxText(text);
    }

    @Step
    public void updateProfile() {
        page.clickUpdateProfileButton();
    }

    @Step
    public void descriptionWasUpdated() {
        
    }

}
