package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.training.at.hw5.JdiPage;
import ru.training.at.hw5.context.TestContext;
import java.util.List;
import static org.testng.Assert.assertTrue;
import static utils.Constants.*;

public class ElementsPageSteps {
    WebDriver driver = TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER);
    JdiPage page = new JdiPage(driver);

    @Given("I click on 'Different Elements Page' in Service dropdown")
    public void openElementsPageFromHeaderMenu() {
        page.openDifferentElementsPage();
    }

    @When("I select checkboxes 'Water' and 'Wind'")
    public void selectCheckboxes() {
        page.selectCheckboxes(0, 2);
    }

    @When("I select radiobutton 'Selen'")
    public void selectRadioButton() {
        page.selectRadioButton(3);
    }

    @When("I select 'Yellow' in dropdown")
    public void selectFromDropdown() {
        page.selectColor(3);
    }

    @Then("log entries should contain \"Water: condition changed to true\"")
    public void assertLogEntriesContainWater() {
        List<WebElement> log = page.getLogEntries();
        String waterLog = log.get(3).getText();
        assertTrue(waterLog.contains(WATER_CHANGED_TO_TRUE_ENTRY));
    }

    @Then("log entries should contain \"Wind: condition changed to true\"")
    public void assertLogEntriesContainWind() {
        List<WebElement> log = page.getLogEntries();
        String windLog = log.get(2).getText();
        assertTrue(windLog.contains(WIND_CHANGED_TO_TRUE_ENTRY));
    }

    @Then("log entries should contain \"metal: value changed to Selen\"")
    public void assertLogEntriesContainSelen() {
        List<WebElement> log = page.getLogEntries();
        String metalLog = log.get(1).getText();
        assertTrue(metalLog.contains(METAL_CHANGED_TO_SELEN_ENTRY));
    }

    @Then("log entries should contain \"Colors: value changed to Yellow\"")
    public void assertLogEntriesContainYellow() {
        List<WebElement> log = page.getLogEntries();
        String colorLog = log.get(0).getText();
        assertTrue(colorLog.contains(COLOR_CHANGED_TO_YELLOW_ENTRY));
    }
}