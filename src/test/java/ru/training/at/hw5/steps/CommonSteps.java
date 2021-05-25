package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.JdiPage;
import ru.training.at.hw5.context.TestContext;

public class CommonSteps {
    WebDriver driver = TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER);
    JdiPage page = new JdiPage(driver);

    @Given("I open JDI home page")
    public void openJdiHomePage() {
        page.openPage();
    }

    @Given("I login with name = {string} and password = {string}")
    public void login(String name, String password) {
        page.getHeaderMenu().login(name, password);
    }
}
