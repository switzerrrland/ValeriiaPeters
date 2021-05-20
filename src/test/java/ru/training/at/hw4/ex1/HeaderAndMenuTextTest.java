package ru.training.at.hw4.ex1;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.JdiPageTest;
import ru.training.at.hw4.utils.ScreenshotListener;
import utils.PropertiesReader;
import java.util.List;
import java.util.Properties;
import static org.testng.Assert.assertTrue;
import static utils.Constants.*;

@Listeners(ScreenshotListener.class)

public class HeaderAndMenuTextTest extends JdiPageTest {
    Properties jdiPageProps = PropertiesReader.readProps(PATH_TO_PROPERTIES);
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void headerAndMenuTextTest() {
        //1. Open test site by URL
        //2. Assert Browser title
        openPageAndAssertTitle(TITLE);
        //3. Perform login
        //4. Assert Username is loggined
        login(jdiPageProps.getProperty("name"),
                jdiPageProps.getProperty("password"),
                jdiPageProps.getProperty("username"));
        //5. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        assertHeader(HEADER_ITEMS_COUNT,
                    HEADER_ITEM_0,
                    HEADER_ITEM_1,
                    HEADER_ITEM_2,
                    HEADER_ITEM_3);
        //6. Assert that there are 4 images on the Index Page and they are displayed
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertBenefits(BENEFIT_ICONS_COUNT,
                    BENEFIT_TEXT_COUNT,
                    BENEFIT_TEXT_0,
                    BENEFIT_TEXT_1,
                    BENEFIT_TEXT_2,
                    BENEFIT_TEXT_3);
        //8. Assert that there is the iframe with “Frame Button” exist
        assertIframeDisplay();
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        assertFrameButtonExists();
        //10. Switch to original window back
        //11. Assert that there are 5 items in the Left Section
        assertLeftMenu(LEFT_MENU_ITEMS_COUNT,
                    LEFT_MENU_ITEM_0,
                    LEFT_MENU_ITEM_1,
                    LEFT_MENU_ITEM_2,
                    LEFT_MENU_ITEM_3,
                    LEFT_MENU_ITEM_4);
    }

    @Step("Assert that the header section has {itemsCount} items with proper texts")
    public void assertHeader(int itemsCount,
                             String headerText0,
                             String headerText1,
                             String headerText2,
                             String headerText3) {
        List<WebElement> header = page.getHeaderMenu().getNavigationHeader();
        softAssert.assertEquals(header.size(), itemsCount);
        softAssert.assertEquals(header.get(0).getText(), headerText0);
        softAssert.assertEquals(header.get(1).getText(), headerText1);
        softAssert.assertEquals(header.get(2).getText(), headerText2);
        softAssert.assertEquals(header.get(3).getText(), headerText3);
    }

    @Step("Assert benefits section")
    public void assertBenefits(int iconsCount,
                               int textsCount,
                               String text0,
                               String text1,
                               String text2,
                               String text3) {
        assertBenefitIcons(iconsCount);
        assertBenefitTexts(textsCount, text0, text1, text2, text3);
    }

    @Step("Assert that there are {iconsCount} images and they are displayed")
    public void assertBenefitIcons(int iconsCount) {
        List<WebElement> icons = page.getBenefitIcons();
        softAssert.assertEquals(icons.size(), iconsCount);
        for (WebElement icon : icons) {
            assertTrue(icon.isDisplayed());
        }
    }

    @Step("Assert that there are {textsCount} texts under icons with proper text")
    public void assertBenefitTexts(int textsCount,
                                   String text0,
                                   String text1,
                                   String text2,
                                   String text3) {
        List<WebElement> texts = page.getBenefitTexts();
        softAssert.assertEquals(texts.size(), textsCount);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
        softAssert.assertEquals(texts.get(0).getText(), text0);
        softAssert.assertEquals(texts.get(1).getText(), text1);
        softAssert.assertEquals(texts.get(2).getText(), text2);
        softAssert.assertEquals(texts.get(3).getText(), text3);
    }

    @Step("Assert that the iframe with “Frame Button” is displayed")
    public void assertIframeDisplay() {
        WebElement iframe = page.getIframe();
        softAssert.assertTrue(iframe.isDisplayed());
    }

    @Step("Switch to the iframe and check that there is “Frame Button” in the iframe")
    public void assertFrameButtonExists() {
        webDriver.switchTo().frame(FRAME_ID);
        WebElement button = page.getFrameButton();
        softAssert.assertTrue(button.isDisplayed());
    }

    @Step("Assert that there are {itemsCount} items in the Left Section and they have proper text")
    public void assertLeftMenu(int itemsCount,
                               String text0,
                               String text1,
                               String text2,
                               String text3,
                               String text4) {
        webDriver.switchTo().defaultContent();
        List<WebElement> leftMenu = page.getLeftSideMenu().getLeftMenuItems();
        softAssert.assertEquals(leftMenu.size(), itemsCount);
        softAssert.assertEquals(leftMenu.get(0).getText(), text0);
        softAssert.assertEquals(leftMenu.get(1).getText(), text1);
        softAssert.assertEquals(leftMenu.get(2).getText(), text2);
        softAssert.assertEquals(leftMenu.get(3).getText(), text3);
        softAssert.assertEquals(leftMenu.get(4).getText(), text4);
    }
}