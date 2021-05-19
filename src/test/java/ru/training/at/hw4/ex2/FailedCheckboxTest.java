package ru.training.at.hw4.ex2;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.training.at.hw4.DataProviders;
import ru.training.at.hw4.JdiPageTest;
import utils.PropertiesReader;

import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertTrue;
import static utils.Constants.*;

public class FailedCheckboxTest extends JdiPageTest {
    Properties jdiPageProps = PropertiesReader.readProps(PATH_TO_PROPERTIES);


    @Test(dataProviderClass = DataProviders.class, dataProvider = "elements indexes")
    public void checkboxTest(int checkBoxIndex1, int checkBoxIndex2,
                             int radioButtonIndex, int colorIndex) {
        //1. Open test site by URL
        //2. Assert Browser title
        openPageAndAssertTitle(TITLE);
        //3. Perform login
        //4. Assert Username is loggined
        login(jdiPageProps.getProperty("name"),
                jdiPageProps.getProperty("password"),
                "lol");
        //5. Open through the header menu Service -> Different Elements Page
        //6. Select checkboxes Water, Wind
        //7. Select radio Selen
        //8. Select in dropdown Yellow
        selectElements(checkBoxIndex1, checkBoxIndex2, radioButtonIndex, colorIndex);
        //9. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded
        // to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        assertLogs(WATER_CHANGED_TO_TRUE_ENTRY, WIND_CHANGED_TO_TRUE_ENTRY,
                METAL_CHANGED_TO_SELEN_ENTRY, COLOR_CHANGED_TO_YELLOW_ENTRY);
    }

    @Step("Select elements on Different element page")
    private void selectElements(int checkBoxIndex1, int checkBoxIndex2,
                                int radioButtonIndex, int colorIndex) {
        page.openDifferentElementsPage();
        page.selectCheckboxes(checkBoxIndex1, checkBoxIndex2);
        page.selectRadioButton(radioButtonIndex);
        page.selectColor(colorIndex);
    }

    @Step("Asserting log entries")
    private void assertLogs(String expectedWaterLog, String expectedWindLog,
                            String expectedMetalLog, String expectedColorLog) {
        List<WebElement> log = page.getLogEntries();
        String waterLog = log.get(3).getText();
        assertTrue(waterLog.contains(expectedWaterLog));
        String windLog = log.get(2).getText();
        assertTrue(windLog.contains(expectedWindLog));
        String metalLog = log.get(1).getText();
        assertTrue(metalLog.contains(expectedMetalLog));
        String colorLog = log.get(0).getText();
        assertTrue(colorLog.contains(expectedColorLog));
    }
}
