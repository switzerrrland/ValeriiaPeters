package ru.training.at.hw5.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.training.at.hw5.JdiPage;
import ru.training.at.hw5.context.TestContext;
import java.util.List;
import static org.testng.Assert.assertTrue;

public class UserTableVipCheckboxSteps {
    WebDriver driver = TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER);
    JdiPage page = new JdiPage(driver);

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectVipCheckbox() {
        page.selectVipCheckboxForIvanUser();
    }

    @Then("1 log row has {string} text in log section")
    public void assertLogEntryContainsVipCheckboxStatusChange(String expectedLogEntry) {
        List<WebElement> log = page.getLogEntries();
        String vipLog = log.get(0).getText();
        assertTrue(vipLog.contains(expectedLogEntry));
    }
}