package ru.training.at.hw2.ex2;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class CheckboxTest {

    @Test
    public void checkboxTest() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //TODO: add waiting
        //1. Open test site by URL
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        //2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");
        //3. Perform login
        WebElement webElement;
        webElement = driver.findElement(By.cssSelector("a[href^=\"#\"]"));
        webElement.click();
        webElement = driver.findElement(By.id("name"));
        webElement.sendKeys("Roman");
        webElement = driver.findElement(By.id("password"));
        webElement.sendKeys("Jdi1234");
        webElement = driver.findElement(By.id("login-button"));
        webElement.click();
        //4. Assert Username is loggined
        webElement = driver.findElement(By.id("user-name"));
        //TODO: change to data providers
        String actualUsername = webElement.getText();
        assertEquals(actualUsername, "ROMAN IOVLEV"); //TODO add visibility wait
        //5. Open through the header menu Service -> Different Elements Page
        List<WebElement> headerElements = driver.findElements(By.cssSelector("ul."
                + "uui-navigation.nav.navbar-nav.m-l8>li"));
        webElement = headerElements.get(2);
        webElement.click();
        webElement = driver.findElement(By.cssSelector("a[href*=\"different-elements.html\"]"));
        webElement.click();
        //6. Select checkboxes Water, Wind
        List<WebElement> checkboxes = driver.findElements(
                By.cssSelector("input[type*=\"checkbox\"]"));
        webElement = checkboxes.get(0);
        webElement.click();
        webElement = checkboxes.get(2);
        webElement.click();
        //7. Select radio Selen
        List<WebElement> radioButtons = driver.findElements(By.name("metal"));
        webElement = radioButtons.get(3);
        webElement.click();
        //8. Select in dropdown Yellow
        //webElement = driver.findElement(By.className("uui-form-element"));
        webElement = driver.findElement(By.cssSelector("select"));
        webElement.click();
        List<WebElement> options = driver.findElements(By.cssSelector("option"));
        webElement = options.get(3);
        webElement.click();
        //9. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded
        // to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> logEntries = driver.findElements(
                By.cssSelector("ul.panel-body-list.logs>li"));
        String waterLog = logEntries.get(3).getText();
        assertTrue(waterLog.contains("Water: condition changed to true"));
        String windLog = logEntries.get(2).getText();
        assertTrue(windLog.contains("Wind: condition changed to true"));
        String metalLog = logEntries.get(1).getText();
        assertTrue(metalLog.contains("metal: value changed to Selen"));
        String colorLog = logEntries.get(0).getText();
        assertTrue(colorLog.contains("Colors: value changed to Yellow"));
        //10. Close Browser
        driver.close();
    }
}
