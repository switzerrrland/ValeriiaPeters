package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class JdiPageTest {
    public WebDriver driver;
    JdiPage jdiPage;

    @BeforeMethod
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void init() {
        jdiPage = new JdiPage(driver);
    }

    //10, 12. Close Browser
    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}