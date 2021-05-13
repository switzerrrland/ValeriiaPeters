package ru.training.at.hw3.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.ContactFormPage;
import ru.training.at.hw3.HeaderMenu;
import ru.training.at.hw3.JdiPageTest;
import utils.PropertiesReader;
//import ru.training.at.hw3.LoginForm;
//TODO parameters and constants
//TODO page composite
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.*;

public class HeaderAndMenuTextTest extends JdiPageTest {
    //TODO read properties
    @Test
    public void headerAndMenuTextTest() {
        ContactFormPage page = PageFactory.initElements(driver, ContactFormPage.class);//TODO move away?
        SoftAssert softAssert = new SoftAssert();
        //1. Open test site by URL
        driver.navigate().to(JDI_HOME_PAGE); // TODO open method?
        //2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), TITLE);
        //3. Perform login
        page.getHeaderMenu().login("Roman", "Jdi1234");//TODO properties
        //4. Assert Username is loggined
        String actualUsername = page.getHeaderMenu().getUsername();
        //Properties epamSiteProps = PropertiesReader.readProps("hfwhfh");
        softAssert.assertEquals(actualUsername, "ROMAN IOVLEV");//TODO properties
        //5. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        List<WebElement> header = page.getHeaderMenu().getNavigationHeader();
        softAssert.assertEquals(header.size(),4); //TODO change to constant?
        softAssert.assertEquals(header.get(0).getText(), "HOME");
        softAssert.assertEquals(header.get(1).getText(), "CONTACT FORM");
        softAssert.assertEquals(header.get(2).getText(), "SERVICE");
        softAssert.assertEquals(header.get(3).getText(), "METALS & COLORS");
        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> icons = page.getBenefitIcons();
        softAssert.assertEquals(icons.size(), 4);
        for (WebElement icon : icons) {
            softAssert.assertTrue(icon.isDisplayed());
        }
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> texts = page.getBenefitTexts();
        softAssert.assertEquals(texts.size(), 4);
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
        driver.switchTo().frame(FRAME_ID);//TODO method?
        WebElement button = page.getFrameButton();
        softAssert.assertTrue(button.isDisplayed());
        //10. Switch to original window back
        driver.switchTo().defaultContent();
        //11. Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        List<WebElement> leftMenu = page.getLeftSideMenu().getLeftMenuItems();
        softAssert.assertEquals(leftMenu.size(), 5);
        softAssert.assertEquals(leftMenu.get(0).getText(), "Home");
        softAssert.assertEquals(leftMenu.get(1).getText(), "Contact form");
        softAssert.assertEquals(leftMenu.get(2).getText(), "Service");
        softAssert.assertEquals(leftMenu.get(3).getText(), "Metals & Colors");
        softAssert.assertEquals(leftMenu.get(4).getText(), "Elements packs");
    }
}