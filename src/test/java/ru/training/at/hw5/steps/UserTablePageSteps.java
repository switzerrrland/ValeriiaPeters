package ru.training.at.hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.training.at.hw5.JdiPage;
import ru.training.at.hw5.context.TestContext;
import utils.CucumberTableIntoListsConverter;
import java.util.List;
import static utils.Constants.*;

public class UserTablePageSteps {
    WebDriver driver = TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER);
    JdiPage page = new JdiPage(driver);
    CucumberTableIntoListsConverter converter = new CucumberTableIntoListsConverter();

    @When("I click on \"User Table\" button in Service dropdown")
    public void clickOnUserTableButtonInServiceDropdown() {
        page.openUserTablePage();
    }

    @Then("\"User Table\" page should be opened")
    public void assertUserTablePageIsOpened() {
        page.assertTitle(USER_TABLE_PAGE_TITLE);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertNumberTypeDropdownsAreDisplayed(int dropdownsCount) {
        List<WebElement> dropdowns = page.getNumberTypeDropdowns();
        Assert.assertEquals(dropdowns.size(), dropdownsCount);
        for (WebElement dropdown : dropdowns) {
            Assert.assertTrue(dropdown.isDisplayed());
        }
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void assertUsernamesAreDisplayed(int usernamesCount) {
        List<WebElement> usernames = page.getUserTableUserNames();
        Assert.assertEquals(usernames.size(), usernamesCount);
        for (WebElement username : usernames) {
            Assert.assertTrue(username.isDisplayed());
        }
    }

    @Then("{int} Description texts should be displayed on Users Table on User Table Page")
    public void assertDescriptionTextsAreDisplayed(int textsCount) {
        List<WebElement> descriptionTexts = page.getUserTableDescriptionTexts();
        Assert.assertEquals(descriptionTexts.size(), textsCount);
        for (WebElement text : descriptionTexts) {
            Assert.assertTrue(text.isDisplayed());
        }
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void assertCheckboxesAreDisplayed(int checkboxesCount) {
        List<WebElement> checkboxes = page.getUserTableCheckBoxes();
        Assert.assertEquals(checkboxes.size(), checkboxesCount);
        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isDisplayed());
        }
    }

    @Then("User table should contain following values:")
    public void assertTableContainsValues(DataTable table) throws Throwable {
        List<String> numbersColumn = converter.getNumbersColumn(table);
        List<String> usersColumn = converter.getUsersColumn(table);
        List<String> descriptionsColumn = converter.getDescriptionsColumn(table);
        Assert.assertEquals(numbersColumn, page.getUserTableNumbersListAsString());
        Assert.assertEquals(usersColumn, page.getUserTableUsersListAsString());
        Assert.assertEquals(descriptionsColumn, page.getUserTableDescriptionsListAsString());
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void assertDroplistContainsValuesForUser(DataTable table) throws Throwable {
        List<String> expectedValues = converter.getDropdownValuesColumn(table);
        List<String> actualValues = page.getUserDropdownValuesAsString();
        Assert.assertEquals(actualValues, expectedValues);
    }
}