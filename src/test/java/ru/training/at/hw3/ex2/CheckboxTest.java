package ru.training.at.hw3.ex2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.JdiPage;
import ru.training.at.hw3.JdiPageTest;
import utils.PropertiesReader;
import java.util.List;
import java.util.Properties;
import static org.testng.Assert.assertTrue;
import static utils.Constants.*;

public class CheckboxTest extends JdiPageTest {

    @Test
    @Parameters({"checkBoxIndex1", "checkBoxIndex2", "radioButtonIndex", "colorIndex"})
    public void checkboxTest(int checkBoxIndex1, int checkBoxIndex2,
                             int radioButtonIndex, int colorIndex) {
        JdiPage page = PageFactory.initElements(driver, JdiPage.class);
        SoftAssert softAssert = new SoftAssert();
        Properties jdiPageProps = PropertiesReader.readProps(PATH_TO_PROPERTIES);
        //1. Open test site by URL
        driver.navigate().to(JDI_HOME_PAGE);
        //2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), TITLE);
        //3. Perform login
        String name = jdiPageProps.getProperty("name");
        String password = jdiPageProps.getProperty("password");
        page.getHeaderMenu().login(name, password);
        //4. Assert Username is loggined
        String actualUsername = page.getHeaderMenu().getUsername();
        String expectedUsername = jdiPageProps.getProperty("username");
        softAssert.assertEquals(actualUsername, expectedUsername);
        //5. Open through the header menu Service -> Different Elements Page
        page.openDifferentElementsPage();
        //6. Select checkboxes Water, Wind
        page.selectCheckboxes(checkBoxIndex1, checkBoxIndex2);
        //7. Select radio Selen
        page.selectRadioButton(radioButtonIndex);
        //8. Select in dropdown Yellow
        page.selectColor(colorIndex);
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
