package ru.training.at.hw3.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.JdiPage;
import ru.training.at.hw3.JdiPageTest;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckboxTest extends JdiPageTest {

    @Test
    public void checkboxTest() {
        //1. Open test site by URL
        driver.navigate().to(JDI_HOME_PAGE);
        //2. Assert Browser title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        //3. Perform login
        WebElement webElement;
        JdiPage page = PageFactory.initElements(driver, JdiPage.class);
        page.login("Roman", "Jdi1234");
        //4. Assert Username is loggined
        String actualUsername = page.getUsername();//TODO data providers
        assertEquals(actualUsername, "ROMAN IOVLEV");
        //5. Open through the header menu Service -> Different Elements Page
        page.openDifferentElementsPage();
        //6. Select checkboxes Water, Wind
        page.selectCheckboxes();//TODO parameters
        //7. Select radio Selen
        page.selectRadioButton();//TODO parameters
        //8. Select in dropdown Yellow
        page.selectColor();
        //9. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded
        // to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> log = page.getLogEntries();//TODO method for separate log lines?
        String waterLog = log.get(3).getText();
        assertTrue(waterLog.contains("Water: condition changed to true"));
        String windLog = log.get(2).getText();
        assertTrue(windLog.contains("Wind: condition changed to true"));
        String metalLog = log.get(1).getText();
        assertTrue(metalLog.contains("metal: value changed to Selen"));
        String colorLog = log.get(0).getText();
        assertTrue(colorLog.contains("Colors: value changed to Yellow"));
    }
}
