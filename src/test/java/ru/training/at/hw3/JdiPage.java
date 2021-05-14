package ru.training.at.hw3;

import driverutils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class JdiPage {
    private HeaderMenu headerMenu;
    private LeftSideMenu leftSideMenu;
    private WaitActions waitActions;
    private WebDriver driver;
    @FindBy(css = ".icons-benefit")
    List<WebElement> benefitIcons;
    @FindBy(css = ".benefit-txt")
    List<WebElement> benefitTexts;
    @FindBy(id = "frame")
    private WebElement iframe;
    @FindBy(id = "frame-button")
    private WebElement frameButton;
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
    @FindBy(css = "ul.panel-body-list.logs>li")
    List<WebElement> logEntries;
    @FindBy(className = "dropdown-toggle")
    private WebElement service;

    public JdiPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        headerMenu = new HeaderMenu(driver);
        leftSideMenu = new LeftSideMenu(driver);
        waitActions = new WaitActions(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
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

    public List<WebElement> getLogEntries() {
        return logEntries;
    }

    public void selectColor(int index) {
        colorSelect.click();
        options.get(index).click();
    }

    public void selectCheckboxes(int...indexes) {
        for (int index : indexes) {
            checkboxes.get(index).click();
        }
    }

    public void selectRadioButton(int index) {
        radioButtons.get(index).click();
    }
}