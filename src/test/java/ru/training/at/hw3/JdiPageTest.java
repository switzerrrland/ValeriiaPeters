package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class JdiPageTest {
    public WebDriver driver;
    ContactFormPage contactFormPage;
    public static final String JDI_HOME_PAGE = "https://jdi-testing.github.io/jdi-light/index.html";
    //TODO data providers
    public static final String BENEFIT_TEXT_0 = "To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project";
    public static final String BENEFIT_TEXT_1 = "To be flexible and\n"
            + "customizable";
    public static final String BENEFIT_TEXT_2 = "To be multiplatform";
    public static final String BENEFIT_TEXT_3 = "Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…";
    public static final String FRAME_ID = "frame";
    public static final int LEFT_MENU_ELEMENTS_COUNT = 5;
    public static final String TITLE = "Home Page";
    public static final String WATER_CHANGED_TO_TRUE_ENTRY = "Water: condition changed to true";
    public static final String WIND_CHANGED_TO_TRUE_ENTRY = "Wind: condition changed to true";
    public static final String METAL_CHANGED_TO_SELEN_ENTRY = "metal: value changed to Selen";
    public static final String COLOR_CHANGED_TO_YELLOW_ENTRY = "Colors: value changed to Yellow";



    @BeforeMethod
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void init() {
        contactFormPage = new ContactFormPage(driver);

    }

    //10, 12. Close Browser
    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}
