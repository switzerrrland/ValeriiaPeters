package ru.training.at.hw5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderMenu {
    @FindBy(className = "profile-photo")
    private WebElement profileIcon;
    @FindBy(id = "name")
    private WebElement user;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement submitButton;
    @FindBy(id = "user-name")
    private WebElement username;
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8>li")
    private List<WebElement> navigationHeader;

    public HeaderMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String name, String password) {
        profileIcon.click();
        user.sendKeys(name);
        this.password.sendKeys(password);
        submitButton.click();
    }

    public List<WebElement> getNavigationHeader() {
        return navigationHeader;
    }

    public String getUsername() {
        return username.getText();
    }
}