package ru.training.at.hw4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeftSideMenu {

    @FindBy(css = "ul.sidebar-menu.left>li")
    private List<WebElement> leftMenuItems;

    public List<WebElement> getLeftMenuItems() {
        return leftMenuItems;
    }

    public LeftSideMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}