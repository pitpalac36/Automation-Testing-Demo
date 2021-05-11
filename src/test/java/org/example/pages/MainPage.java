package org.example.pages;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

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

    @FindBy(className = "courses course-search-result course-search-result-search")
    private WebElement courses;

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

    public void clickEditProfile(WebDriver driver) {
        driver.findElement(By.xpath("//a[@href=\'https://moodle.cs.ubbcluj.ro/user/edit.php?id=4075&returnto=profile\']")).click();
    }

    public void divExistsAndContains(WebDriver driver, String text) {
        List<WebElement> result = driver.findElements(By.xpath("//div[contains(@class, 'coursebox clearfix')]")).stream()
                .peek(x -> x.findElement(By.tagName("span"))).collect(Collectors.toList());
        //System.out.println("Cursuri gasite : " + result.size());
        for (WebElement each : result) {
            assert (each.getText().contains(text));
        }
    }
}
