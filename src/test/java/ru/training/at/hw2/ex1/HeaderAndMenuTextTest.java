package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.testng.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HeaderAndMenuTextTest {


    @Test
    public void headerAndMenuTextTest() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //TODO: add waiting
        //1. Open test site by URL
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        //2. Assert Browser title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Home Page");
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
        softAssert.assertEquals(actualUsername, "ROMAN IOVLEV"); //TODO add visibility wait
        //5. Assert that there are 4 items on the header section
        // are displayed and they have proper texts TODO displayed
        List<WebElement> headerElements = driver.findElements(By.cssSelector("ul."
                + "uui-navigation.nav.navbar-nav.m-l8>li"));
        softAssert.assertEquals(headerElements.size(), 4);
        softAssert.assertEquals(headerElements.get(0).getText(), "HOME");
        softAssert.assertEquals(headerElements.get(1).getText(), "CONTACT FORM");
        softAssert.assertEquals(headerElements.get(2).getText(), "SERVICE");
        softAssert.assertEquals(headerElements.get(3).getText(), "METALS & COLORS");
        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = driver.findElements(By.cssSelector(".icons-benefit"));
        softAssert.assertEquals(benefitIcons.size(), 4);
        softAssert.assertTrue(benefitIcons.get(0).isDisplayed());
        softAssert.assertTrue(benefitIcons.get(1).isDisplayed());
        softAssert.assertTrue(benefitIcons.get(2).isDisplayed());
        softAssert.assertTrue(benefitIcons.get(3).isDisplayed());
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        //TODO create variables for actual text
        List<WebElement> benefitTexts = driver.findElements(By.cssSelector(".benefit-txt"));
        softAssert.assertEquals(benefitTexts.size(), 4);
        softAssert.assertTrue(benefitTexts.get(0).isDisplayed());
        softAssert.assertEquals(benefitTexts.get(0).getText(), "To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project");
        softAssert.assertTrue(benefitTexts.get(1).isDisplayed());
        softAssert.assertEquals(benefitTexts.get(1).getText(), "To be flexible and\n"
                + "customizable");
        softAssert.assertTrue(benefitTexts.get(2).isDisplayed());
        softAssert.assertEquals(benefitTexts.get(2).getText(), "To be multiplatform");
        softAssert.assertTrue(benefitTexts.get(3).isDisplayed());
        softAssert.assertEquals(benefitTexts.get(3).getText(), "Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…");
        //8. Assert that there is the iframe with “Frame Button” exist
        driver.switchTo().frame("frame");
        softAssert.assertTrue(driver.getPageSource().contains("frame")); //TODO not the same??
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webElement = driver.findElement(By.id("frame-button"));
        softAssert.assertTrue(webElement.isDisplayed());
        //10. Switch to original window back
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        //11. Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        List<WebElement> leftSectionElements = driver.findElements(By.cssSelector(
                "ul.sidebar-menu.left>li"));
        softAssert.assertEquals(leftSectionElements.size(), 5);
        //12. Close Browser
        driver.close();
    }
}