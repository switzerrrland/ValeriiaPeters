package ru.training.at.hw4;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.training.at.hw4.utils.DriverManager;
import static org.testng.Assert.assertEquals;

public abstract class JdiPageTest {
    public WebDriver webDriver;
    protected JdiPage page;

    public WebDriver getDriver() {
        return webDriver;
    }

    @BeforeMethod
    public void startBrowser() {
        webDriver = DriverManager.setUpDriver();
    }

    @Step("Open test page and assert title")
    public void openPageAndAssertTitle(String title) {
        page = new JdiPage(webDriver);
        page.openPage();
        page.assertTitle(title);
    }

    @Step("Perform login ({name}/{password}) and assert username = {expectedUsername}")
    public void login(String name, String password, String expectedUsername) {
        page.getHeaderMenu().login(name, password);
        String actualUsername = page.getHeaderMenu().getUsername();
        assertEquals(actualUsername, expectedUsername);
    }

    //10, 12. Close Browser
    @AfterMethod
    public void closeBrowser() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}