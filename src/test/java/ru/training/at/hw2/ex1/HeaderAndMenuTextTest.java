package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.JdiPageTest;
import java.util.List;

public class HeaderAndMenuTextTest extends JdiPageTest {
    public static final String jdiHomePage = "https://jdi-testing.github.io/jdi-light/index.html";

    @Test
    public void headerAndMenuTextTest() {
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
        //5. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        List<WebElement> headerElements = driver.findElements(By.cssSelector("ul."
                + "uui-navigation.nav.navbar-nav.m-l8>li"));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(headerElements));
        softAssert.assertEquals(headerElements.size(), 4);
        softAssert.assertEquals(headerElements.get(0).getText(), "HOME");
        softAssert.assertEquals(headerElements.get(1).getText(), "CONTACT FORM");
        softAssert.assertEquals(headerElements.get(2).getText(), "SERVICE");
        softAssert.assertEquals(headerElements.get(3).getText(), "METALS & COLORS");
        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = driver.findElements(By.cssSelector(".icons-benefit"));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(benefitIcons));
        softAssert.assertEquals(benefitIcons.size(), 4);
        softAssert.assertTrue(benefitIcons.get(0).isDisplayed());
        softAssert.assertTrue(benefitIcons.get(1).isDisplayed());
        softAssert.assertTrue(benefitIcons.get(2).isDisplayed());
        softAssert.assertTrue(benefitIcons.get(3).isDisplayed());
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitTexts = driver.findElements(By.cssSelector(".benefit-txt"));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(benefitTexts));
        softAssert.assertEquals(benefitTexts.size(), 4);
        softAssert.assertTrue(benefitTexts.get(0).isDisplayed());
        String benefitText0 = "To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project";
        softAssert.assertEquals(benefitTexts.get(0).getText(), benefitText0);
        softAssert.assertTrue(benefitTexts.get(1).isDisplayed());
        String benefitText1 = "To be flexible and\n"
                + "customizable";
        softAssert.assertEquals(benefitTexts.get(1).getText(), benefitText1);
        softAssert.assertTrue(benefitTexts.get(2).isDisplayed());
        String benefitText2 = "To be multiplatform";
        softAssert.assertEquals(benefitTexts.get(2).getText(), benefitText2);
        softAssert.assertTrue(benefitTexts.get(3).isDisplayed());
        String benefitText3 = "Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…";
        softAssert.assertEquals(benefitTexts.get(3).getText(), benefitText3);
        //8. Assert that there is the iframe with “Frame Button” exist
        webElement = driver.findElement(By.id("frame"));
        softAssert.assertTrue(webElement.isDisplayed());
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        webElement = driver.findElement(By.id("frame-button"));
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        softAssert.assertTrue(webElement.isDisplayed());
        //10. Switch to original window back
        driver.switchTo().defaultContent();
        //11. Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        List<WebElement> leftSectionElements = driver.findElements(By.cssSelector(
                "ul.sidebar-menu.left>li"));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(leftSectionElements));
        softAssert.assertEquals(leftSectionElements.size(), 5);
        softAssert.assertEquals(leftSectionElements.get(0).getText(), "Home");
        softAssert.assertEquals(leftSectionElements.get(1).getText(), "Contact form");
        softAssert.assertEquals(leftSectionElements.get(2).getText(), "Service");
        softAssert.assertEquals(leftSectionElements.get(3).getText(), "Metals & Colors");
        softAssert.assertEquals(leftSectionElements.get(4).getText(), "Elements packs");
    }
}