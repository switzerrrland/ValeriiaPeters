package ru.training.at.hw3.ex2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.ContactFormPage;
import ru.training.at.hw3.JdiPageTest;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckboxTest extends JdiPageTest {

    @Test
    public void checkboxTest() {
        ContactFormPage page = PageFactory.initElements(driver, ContactFormPage.class);
        SoftAssert softAssert = new SoftAssert();
        //1. Open test site by URL
        driver.navigate().to(JDI_HOME_PAGE);
        //2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), TITLE);
        //3. Perform login
        page.getHeaderMenu().login("Roman", "Jdi1234");//TODO properties
        //4. Assert Username is loggined
        String actualUsername = page.getHeaderMenu().getUsername();
        assertEquals(actualUsername, "ROMAN IOVLEV");
        //5. Open through the header menu Service -> Different Elements Page
        page.openDifferentElementsPage();
        //6. Select checkboxes Water, Wind
        page.selectCheckboxes(0, 2); //TODO data providers
        //7. Select radio Selen
        page.selectRadioButton(3); //TODO data providers
        //8. Select in dropdown Yellow
        page.selectColor(3); //TODO data providers
        //9. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded
        // to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> log = page.getLogEntries();
        String waterLog = log.get(3).getText();
        assertTrue(waterLog.contains(WATER_CHANGED_TO_TRUE_ENTRY));
        String windLog = log.get(2).getText();
        assertTrue(windLog.contains(WIND_CHANGED_TO_TRUE_ENTRY));
        String metalLog = log.get(1).getText();
        assertTrue(metalLog.contains(METAL_CHANGED_TO_SELEN_ENTRY));
        String colorLog = log.get(0).getText();
        assertTrue(colorLog.contains(COLOR_CHANGED_TO_YELLOW_ENTRY));
    }
}
