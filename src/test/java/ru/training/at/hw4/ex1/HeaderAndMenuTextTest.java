package ru.training.at.hw4.ex1;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import ru.training.at.hw4.JdiPage;
import ru.training.at.hw4.JdiPageTest;
import utils.PropertiesReader;

import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.Constants.*;
//TODO change to soft assert again
//TODO extra folders so evrth looks neat

public class HeaderAndMenuTextTest extends JdiPageTest {
    //JdiPage page = PageFactory.initElements(webDriver, JdiPage.class);

    @Test
    public void headerAndMenuTextTest() {
        JdiPage page = PageFactory.initElements(webDriver, JdiPage.class);
        //SoftAssert softAssert = new SoftAssert();
        Properties jdiPageProps = PropertiesReader.readProps(PATH_TO_PROPERTIES);
        //1. Open test site by URL
        //2. Assert Browser title
        openPageAndAssertTitle();
        //3. Perform login
        login(jdiPageProps.getProperty("name"), jdiPageProps.getProperty("password"), page);
        //4. Assert Username is loggined
        String expectedUsername = jdiPageProps.getProperty("username");
        assertUsername(expectedUsername, page);
        //5. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        assertHeader(page);
        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertBenefitIcons(page);
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertBenefitTexts(page);
        //8. Assert that there is the iframe with “Frame Button” exist
        assertIframeDisplay(page);
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        assertFrameButtonExists(page);
        //10. Switch to original window back
        //11. Assert that there are 5 items in the Left Section
        assertLeftMenu(page);
    }

    @Step(value="assert header")
    public void assertHeader(JdiPage page) {
        List<WebElement> header = page.getHeaderMenu().getNavigationHeader();
        assertEquals(header.size(), HEADER_ITEMS_COUNT);
        assertEquals(header.get(0).getText(), HEADER_ITEM_0);
        assertEquals(header.get(1).getText(), HEADER_ITEM_1);
        assertEquals(header.get(2).getText(), HEADER_ITEM_2);
        assertEquals(header.get(3).getText(), HEADER_ITEM_3);
    }

    @Step("dfjklsdfhjkl")
    public void assertBenefitIcons(JdiPage page) {
        List<WebElement> icons = page.getBenefitIcons();
        assertEquals(icons.size(), BENEFIT_ICONS_COUNT);
        for (WebElement icon : icons) {
            assertTrue(icon.isDisplayed());
        }
    }

    @Step
    public void assertBenefitTexts(JdiPage page) {//TODO get rid of page everywhere. Move some methods to jditestpage class?
        List<WebElement> texts = page.getBenefitTexts();
        assertEquals(texts.size(), BENEFIT_TEXT_COUNT);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
        assertEquals(texts.get(0).getText(), BENEFIT_TEXT_0);
        assertEquals(texts.get(1).getText(), BENEFIT_TEXT_1);
        assertEquals(texts.get(2).getText(), BENEFIT_TEXT_2);
        assertEquals(texts.get(3).getText(), BENEFIT_TEXT_3);
    }

    @Step
    public void assertIframeDisplay(JdiPage page) {
        WebElement iframe = page.getIframe();
        assertTrue(iframe.isDisplayed());
    }

    @Step
    public void assertFrameButtonExists(JdiPage page) {
        webDriver.switchTo().frame(FRAME_ID);
        WebElement button = page.getFrameButton();
        assertTrue(button.isDisplayed());
    }

    @Step
    public void assertLeftMenu(JdiPage page) {
        webDriver.switchTo().defaultContent();
        List<WebElement> leftMenu = page.getLeftSideMenu().getLeftMenuItems();
        assertEquals(leftMenu.size(), LEFT_MENU_ITEMS_COUNT);
        assertEquals(leftMenu.get(0).getText(), LEFT_MENU_ITEM_0);
        assertEquals(leftMenu.get(1).getText(), LEFT_MENU_ITEM_1);
        assertEquals(leftMenu.get(2).getText(), LEFT_MENU_ITEM_2);
        assertEquals(leftMenu.get(3).getText(), LEFT_MENU_ITEM_3);
        assertEquals(leftMenu.get(4).getText(), LEFT_MENU_ITEM_4);
    }
}