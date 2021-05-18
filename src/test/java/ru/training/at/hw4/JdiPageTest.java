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

    public WebDriver webDriver;
    /*JdiPage page = PageFactory.initElements(webDriver, JdiPage.class);
    Properties jdiPageProps = PropertiesReader.readProps(PATH_TO_PROPERTIES);*/
    //TODO  @Step
    //    public void openPageAndCheckTitle(String title) {
    //        mainPage = new JdiPage(driver);
    //        mainPage.openPage();
    //        assertTrue(mainPage.checkTitle(title), "wrong title");
    //    }
    //    protected JdiPage mainPage;
    //import ru.training.at.hw4.JdiPage;



    @BeforeMethod
    public void startBrowser() {
        webDriver = DriverManager.setUpDriver();
    }

 /*   public void init() {
        page = new JdiPage(webDriver);
    }*/

    @Step("Open test site by URL, assert browser title")
   public void openPageAndAssertTitle() {
       webDriver.navigate().to(String.valueOf(JDI_HOME_PAGE));
       assertEquals(webDriver.getTitle(), TITLE);
   }

     @Step("Perform login")
   public void login(String name, String password, JdiPage page) {
       page.getHeaderMenu().login(name, password);
   }

   @Step("Assert username")
    public void assertUsername(String expectedUsername, JdiPage page) {
        String actualUsername = page.getHeaderMenu().getUsername();
        assertEquals(actualUsername, expectedUsername);
    }

    //10, 12. Close Browser
    @AfterMethod
    public void closeBrowser() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}