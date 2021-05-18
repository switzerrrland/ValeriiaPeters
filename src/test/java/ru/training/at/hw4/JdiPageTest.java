package ru.training.at.hw4;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import ru.training.at.hw4.driverutils.GuiceDriverManager;
import ru.training.at.hw4.driverutils.DriverManager;
import utils.PropertiesReader;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.Constants.*;

public abstract class JdiPageTest {
    //private final Injector injector = Guice.createInjector(new GuiceDriverManager());

    //@Inject
    //public
    public WebDriver webDriver;
    /*JdiPage page = PageFactory.initElements(webDriver, JdiPage.class);
    Properties jdiPageProps = PropertiesReader.readProps(PATH_TO_PROPERTIES);*/



    @BeforeMethod
    public void startBrowser() {
        /*injector.injectMembers(this);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();*/
        webDriver = DriverManager.setUpDriver();
    }

 /*   public void init() {
        page = new JdiPage(webDriver);
    }*/

    /*@Step("Open test site by URL, assert browser title")
   public void openPageAndAssertTitle() {
       webDriver.navigate().to(String.valueOf(JDI_HOME_PAGE));
       assertEquals(webDriver.getTitle(), TITLE);
   }

     @Step("Perform login")
   public void login() {
       String name = jdiPageProps.getProperty("name");
       String password = jdiPageProps.getProperty("password");
       page.getHeaderMenu().login(name, password);
   }

   @Step("Assert username")
    public void assertUsername() {
        String actualUsername = page.getHeaderMenu().getUsername();
        String expectedUsername = jdiPageProps.getProperty("username");
        assertEquals(actualUsername, expectedUsername);
    }*/

    /*@Step
    public void assertHeader() {
        List<WebElement> header = page.getHeaderMenu().getNavigationHeader();
        assertEquals(header.size(), HEADER_ITEMS_COUNT);
        assertEquals(header.get(0).getText(), HEADER_ITEM_0);
        assertEquals(header.get(1).getText(), HEADER_ITEM_1);
        assertEquals(header.get(2).getText(), HEADER_ITEM_2);
        assertEquals(header.get(3).getText(), HEADER_ITEM_3);
    }

    @Step
    public void assertBenefitIcons() {
        List<WebElement> icons = page.getBenefitIcons();
        assertEquals(icons.size(), BENEFIT_ICONS_COUNT);
        for (WebElement icon : icons) {
            assertTrue(icon.isDisplayed());
        }
    }

    @Step
    public void assertBenefitTexts() {
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
    public void assertIframeDisplay() {
        WebElement iframe = page.getIframe();
        assertTrue(iframe.isDisplayed());
    }

    @Step
    public void assertFrameButtonExists() {
        webDriver.switchTo().frame(FRAME_ID);
        WebElement button = page.getFrameButton();
        assertTrue(button.isDisplayed());
    }

    @Step
    public void assertleftMenu() {
        webDriver.switchTo().defaultContent();
        List<WebElement> leftMenu = page.getLeftSideMenu().getLeftMenuItems();
        assertEquals(leftMenu.size(), LEFT_MENU_ITEMS_COUNT);
        assertEquals(leftMenu.get(0).getText(), LEFT_MENU_ITEM_0);
        assertEquals(leftMenu.get(1).getText(), LEFT_MENU_ITEM_1);
        assertEquals(leftMenu.get(2).getText(), LEFT_MENU_ITEM_2);
        assertEquals(leftMenu.get(3).getText(), LEFT_MENU_ITEM_3);
        assertEquals(leftMenu.get(4).getText(), LEFT_MENU_ITEM_4);
    }*/

    //10, 12. Close Browser
    @AfterMethod
    public void closeBrowser() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}