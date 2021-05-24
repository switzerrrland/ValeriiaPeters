package ru.training.at.hw4.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.training.at.hw4.JdiPageTest;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            makeScreenshot(((JdiPageTest) result.getInstance()).getDriver());
        } catch (NullPointerException npe) {
            System.out.println("Driver not found");
        }
    }

    @Attachment(type = "image/png", fileExtension = "png")
    private byte[] makeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}