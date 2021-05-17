package ru.training.at.hw4.ex1;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.JdiPage;
import ru.training.at.hw4.JdiPageTest;
import utils.PropertiesReader;
import java.util.List;
import java.util.Properties;
import static utils.Constants.*;


public class HeaderAndMenuTextTest extends JdiPageTest {

    @Test
    public void headerAndMenuTextTest() {
        JdiPage page = PageFactory.initElements(driver, JdiPage.class);
        SoftAssert softAssert = new SoftAssert();
        Properties jdiPageProps = PropertiesReader.readProps(PATH_TO_PROPERTIES);
        //1. Open test site by URL
        driver.navigate().to(String.valueOf(JDI_HOME_PAGE));
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
        //5. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        List<WebElement> header = page.getHeaderMenu().getNavigationHeader();
        softAssert.assertEquals(header.size(), HEADER_ITEMS_COUNT);
        softAssert.assertEquals(header.get(0).getText(), HEADER_ITEM_0);
        softAssert.assertEquals(header.get(1).getText(), HEADER_ITEM_1);
        softAssert.assertEquals(header.get(2).getText(), HEADER_ITEM_2);
        softAssert.assertEquals(header.get(3).getText(), HEADER_ITEM_3);
        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> icons = page.getBenefitIcons();
        softAssert.assertEquals(icons.size(), BENEFIT_ICONS_COUNT);
        for (WebElement icon : icons) {
            softAssert.assertTrue(icon.isDisplayed());
        }
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> texts = page.getBenefitTexts();
        softAssert.assertEquals(texts.size(), BENEFIT_TEXT_COUNT);
        for (WebElement text : texts) {
            softAssert.assertTrue(text.isDisplayed());
        }
        softAssert.assertEquals(texts.get(0).getText(), BENEFIT_TEXT_0);
        softAssert.assertEquals(texts.get(1).getText(), BENEFIT_TEXT_1);
        softAssert.assertEquals(texts.get(2).getText(), BENEFIT_TEXT_2);
        softAssert.assertEquals(texts.get(3).getText(), BENEFIT_TEXT_3);
        //8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = page.getIframe();
        softAssert.assertTrue(iframe.isDisplayed());
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(FRAME_ID);
        WebElement button = page.getFrameButton();
        softAssert.assertTrue(button.isDisplayed());
        //10. Switch to original window back
        driver.switchTo().defaultContent();
        //11. Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        List<WebElement> leftMenu = page.getLeftSideMenu().getLeftMenuItems();
        softAssert.assertEquals(leftMenu.size(), LEFT_MENU_ITEMS_COUNT);
        softAssert.assertEquals(leftMenu.get(0).getText(), LEFT_MENU_ITEM_0);
        softAssert.assertEquals(leftMenu.get(1).getText(), LEFT_MENU_ITEM_1);
        softAssert.assertEquals(leftMenu.get(2).getText(), LEFT_MENU_ITEM_2);
        softAssert.assertEquals(leftMenu.get(3).getText(), LEFT_MENU_ITEM_3);
        softAssert.assertEquals(leftMenu.get(4).getText(), LEFT_MENU_ITEM_4);
    }
}