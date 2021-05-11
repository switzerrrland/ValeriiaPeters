package ru.training.at.hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class JdiPageTest {
    public WebDriver driver;

    @BeforeMethod
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    //10, 12. Close Browser
    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}
