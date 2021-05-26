package ru.training.at.hw5.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.JdiPage;
import ru.training.at.hw5.context.TestContext;

public class CommonSteps {
    WebDriver driver = TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER);
    JdiPage page = new JdiPage(driver);

    @Given("I open JDI GitHub site")
    public void openJdiHomePage() {
        page.openPage();
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void login() {
        page.getHeaderMenu().login();
    }

    @When("I click on \"Service\" button in Header")
    public void clickOnServiceButtonInHeader() {
        page.openServiceDropdown();
    }
}
