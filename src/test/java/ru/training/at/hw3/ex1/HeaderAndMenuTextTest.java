package ru.training.at.hw3.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.JdiPage;
import ru.training.at.hw3.JdiPageTest;
//import ru.training.at.hw3.LoginForm;
//TODO data providers
//TODO page composite
import java.util.List;
import static org.testng.Assert.*;

public class HeaderAndMenuTextTest extends JdiPageTest {

    @Test
    public void headerAndMenuTextTest() {
        //1. Open test site by URL
        driver.navigate().to(JDI_HOME_PAGE); // TODO open method?
        //2. Assert Browser title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        //3. Perform login
        JdiPage page = PageFactory.initElements(driver, JdiPage.class);
        page.login("Roman", "Jdi1234");
        //4. Assert Username is loggined
        String actualUsername = page.getUsername();//TODO data providers
        assertEquals(actualUsername, "ROMAN IOVLEV");
        //5. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        List<WebElement> header = page.getHeaderElements();
        assertEquals(header.size(),4); //TODO change to soft assert in all ex1
        assertEquals(header.get(0).getText(), "HOME");
        assertEquals(header.get(1).getText(), "CONTACT FORM");
        assertEquals(header.get(2).getText(), "SERVICE");
        assertEquals(header.get(3).getText(), "METALS & COLORS");
        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> icons = page.getBenefitIcons();
        assertEquals(icons.size(), 4);
        assertTrue(icons.get(0).isDisplayed());
        assertTrue(icons.get(1).isDisplayed());
        assertTrue(icons.get(2).isDisplayed());
        assertTrue(icons.get(3).isDisplayed());
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> texts = page.getBenefitTexts();//TODO make better -- get text right away?or create method for it?
        assertEquals(texts.size(), 4);
        assertTrue(texts.get(0).isDisplayed());
        String benefitText0 = "To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project";
        assertEquals(texts.get(0).getText(), benefitText0);
        assertTrue(texts.get(1).isDisplayed());
        String benefitText1 = "To be flexible and\n"
                + "customizable";
        assertEquals(texts.get(1).getText(), benefitText1);
        assertTrue(texts.get(2).isDisplayed());
        String benefitText2 = "To be multiplatform";
        assertEquals(texts.get(2).getText(), benefitText2);
        assertTrue(texts.get(3).isDisplayed());
        String benefitText3 = "Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…";
        assertEquals(texts.get(3).getText(), benefitText3);
        //8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = page.getIframe();
        assertTrue(iframe.isDisplayed());
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");//TODO method?
        WebElement button = page.getFrameButton();
        assertTrue(button.isDisplayed());
        //10. Switch to original window back
        driver.switchTo().defaultContent();
        //11. Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        List<WebElement> leftMenu = page.getLeftMenuElements();
        assertEquals(leftMenu.size(), 5);
        assertEquals(leftMenu.get(0).getText(), "Home");
        assertEquals(leftMenu.get(1).getText(), "Contact form");
        assertEquals(leftMenu.get(2).getText(), "Service");
        assertEquals(leftMenu.get(3).getText(), "Metals & Colors");
        assertEquals(leftMenu.get(4).getText(), "Elements packs");
    }
}