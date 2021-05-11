package ru.training.at.hw2.ex2;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.JdiPageTest;
import java.util.List;

public class CheckboxTest extends JdiPageTest {
    public static final String jdiHomePage = "https://jdi-testing.github.io/jdi-light/index.html";

    @Test
    public void checkboxTest() {
        //1. Open test site by URL
        driver.navigate().to(jdiHomePage);
        //2. Assert Browser title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        //3. Perform login
        WebElement webElement;
        webElement = driver.findElement(By.className("profile-photo"));
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
        webElement = driver.findElement(By.id("name"));
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys("Roman");
        webElement = driver.findElement(By.id("password"));
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys("Jdi1234");
        webElement = driver.findElement(By.id("login-button"));
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
        //4. Assert Username is loggined
        webElement = driver.findElement(By.id("user-name"));
        String actualUsername = webElement.getText();
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        softAssert.assertEquals(actualUsername, "ROMAN IOVLEV");
        //5. Open through the header menu Service -> Different Elements Page
        webElement = driver.findElement(By.className("dropdown-toggle"));
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
        webElement = driver.findElement(By.linkText("DIFFERENT ELEMENTS"));
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
        //6. Select checkboxes Water, Wind
        List<WebElement> checkboxes = driver.findElements(
                By.className("label-checkbox"));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(checkboxes));
        webElement = checkboxes.get(0);
        webElement.click();
        webElement = checkboxes.get(2);
        webElement.click();
        //7. Select radio Selen
        List<WebElement> radioButtons = driver.findElements(By.name("metal"));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(radioButtons));
        webElement = radioButtons.get(3);
        webElement.click();
        //8. Select in dropdown Yellow
        webElement = driver.findElement(By.cssSelector("select"));
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
        List<WebElement> options = driver.findElements(By.cssSelector("option"));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(options));
        webElement = options.get(3);
        webElement.click();
        //9. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded
        // to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> logEntries = driver.findElements(
                By.cssSelector("ul.panel-body-list.logs>li"));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(logEntries));
        String waterLog = logEntries.get(3).getText();
        assertTrue(waterLog.contains("Water: condition changed to true"));
        String windLog = logEntries.get(2).getText();
        assertTrue(windLog.contains("Wind: condition changed to true"));
        String metalLog = logEntries.get(1).getText();
        assertTrue(metalLog.contains("metal: value changed to Selen"));
        String colorLog = logEntries.get(0).getText();
        assertTrue(colorLog.contains("Colors: value changed to Yellow"));
    }
}
