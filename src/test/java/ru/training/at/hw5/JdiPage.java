package ru.training.at.hw5;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.stream.Collectors;
import static org.testng.Assert.assertEquals;
import static utils.Constants.JDI_HOME_PAGE;

public class JdiPage {
    private HeaderMenu headerMenu;
    WebDriver webDriver;
    @FindBy(css = ".icons-benefit")
    List<WebElement> benefitIcons;
    @FindBy(css = ".benefit-txt")
    List<WebElement> benefitTexts;
    @FindBy(id = "frame")
    private WebElement iframe;
    @FindBy(id = "frame-button")
    private WebElement frameButton;
    @FindBy(linkText = "User Table ")
    private WebElement userTable;
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
    @FindBy(css = "select")
    List<WebElement> numberTypeDropdowns;
    @FindBy(css = "ul.dropdown-menu>li")
    List<WebElement> serviceDropdownElements;
    @FindBy(css = "#user-table>tbody>tr>td:nth-child(3)>a")
    List<WebElement> userTableUserNames;
    @FindBy(css = "#user-table>tbody>tr>td:nth-child(4)>div.user-descr>span")
    List<WebElement> userTableDescriptionTexts;
    @FindBy(css = "tr>td:nth-child(1)")
    List<WebElement> userTableNumbersList;
    @FindBy(css = "tr>td:nth-child(3)>a")
    List<WebElement> userTableUsersList;
    @FindBy(css = "tr>td:nth-child(4)>div>span")
    List<WebElement> userTableDescriptionsList;
    @FindBy(css = "#user-table>tbody>tr>td:nth-child(4)>div.user-descr>input[type='checkbox']")
    public List<WebElement> userTableCheckBoxes;
    @FindBy(css = "table tr:nth-child(1)>td:nth-child(2) option")
    private List<WebElement> userDropdownValues;

    public List<String> getUserTableNumbersListAsString() {
        List<String> result = userTableNumbersList.stream().map(WebElement::getText)
                .collect(Collectors.toList());
        return result;
    }

    public List<String> getUserTableUsersListAsString() {
        List<String> result = userTableUsersList.stream().map(WebElement::getText)
                .collect(Collectors.toList());
        return result;
    }

    public List<String> getUserTableDescriptionsListAsString() {
        List<String> result = userTableDescriptionsList.stream().map(WebElement::getText)
                .collect(Collectors.toList());
        return result;
    }

    public List<String> getUserDropdownValuesAsString() {
        List<String> result =  userDropdownValues.stream().map(WebElement::getText)
                .collect(Collectors.toList());
        return result;
    }

    public List<WebElement> getUserTableUserNames() {
        return userTableUserNames;
    }

    public List<WebElement> getUserTableDescriptionTexts() {
        return userTableDescriptionTexts;
    }

    public List<WebElement> getUserTableCheckBoxes() {
        return userTableCheckBoxes;
    }

    public List<WebElement> getNumberTypeDropdowns() {
        return numberTypeDropdowns;
    }

    public JdiPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
        headerMenu = new HeaderMenu(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
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

    @Step("Open \"Different elements\" page")
    public void openDifferentElementsPage() {
        serviceDropdownElements.get(7).click();
    }

    public void openServiceDropdown() {
        service.click();
    }

    public void openUserTablePage() {
        serviceDropdownElements.get(5).click();
    }

    public List<WebElement> getLogEntries() {
        return logEntries;
    }

    @Step("Select color")
    public void selectColor(int index) {
        colorSelect.click();
        options.get(index).click();
    }

    @Step("Select checkboxes")
    public void selectCheckboxes(int...indexes) {
        for (int index : indexes) {
            checkboxes.get(index).click();
        }
    }

    @Step("Select radio button")
    public void selectRadioButton(int index) {
        radioButtons.get(index).click();
    }

    @Step("Open Home page")
    public void openPage() {
        webDriver.navigate().to(String.valueOf(JDI_HOME_PAGE));
    }

    @Step("Assert title = {title}")
    public void assertTitle(String title) {
        assertEquals(webDriver.getTitle(), title);
    }
}