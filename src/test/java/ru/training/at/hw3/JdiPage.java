package ru.training.at.hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JdiPage {
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
    List<WebElement> headerElements;
    @FindBy(css = ".icons-benefit")
    List<WebElement> benefitIcons;
    @FindBy(css = ".benefit-txt")
    List<WebElement> benefitTexts;
    @FindBy(id = "frame")
    private WebElement iframe;
    @FindBy(id = "frame-button")
    private WebElement frameButton;
    @FindBy(css = "ul.sidebar-menu.left>li")
    List<WebElement> leftMenuElements;
    @FindBy(className = "dropdown-toggle")
    private WebElement service;
    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElements;
    @FindBy(className = "label-checkbox")
    List<WebElement> checkboxes;
    @FindBy(name = "metal")
    List<WebElement> radioButtons;
    @FindBy(css = "select")
    WebElement colorSelect;
    @FindBy(css = "option")
    List<WebElement> options;

    public List<WebElement> getLogEntries() {
        return logEntries;
    }

    @FindBy(css = "ul.panel-body-list.logs>li")
    List<WebElement> logEntries;

    public void selectColor() {
        colorSelect.click();
        options.get(3).click();
    }

    public void selectCheckboxes() {//TODO int...params
        checkboxes.get(0).click();
        checkboxes.get(2).click();
    }

    public void selectRadioButton() {
        radioButtons.get(3).click();
    }

    public List<WebElement> getLeftMenuElements() {
        return leftMenuElements;
    }

    public void login(String name, String password) { //TODO waiting
        profileIcon.click();
        user.sendKeys(name);
        this.password.sendKeys(password); //TODO this?
        submitButton.click();
    }

    public String getUsername() {
        return username.getText();
    }

    public List<WebElement> getHeaderElements() {
        return headerElements;
    }

    public List<WebElement> getBenefitIcons() {
        return benefitIcons;
    }

    public List<WebElement> getBenefitTexts() {
        return benefitTexts;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public void openDifferentElementsPage() {
        service.click();
        differentElements.click();
    }

    /*    private HeaderMenu headerMenu;
    private LeftSideMenu leftSideMenu;
    private LoginForm loginForm;

    public JdiPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        headerMenu = new HeaderMenu();
        leftSideMenu = new LeftSideMenu();
        loginForm = new LoginForm();
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }*/
}
