package ru.training.at.hw4.driverutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
//TODO delete extra manager stuff
//TODO delete options
public class DriverManager {
    public static WebDriver setUpDriver() {
        WebDriverManager.chromedriver().setup();
        //ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
