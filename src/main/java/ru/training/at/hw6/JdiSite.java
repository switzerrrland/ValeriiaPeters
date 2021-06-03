package ru.training.at.hw6;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Button;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    @Url("/index.html")
    public static JdiHomePage jdiHomePage;
    public static JdiMetalsAndColorsPage jdiMetalsAndColorsPage;
    @FindBy(css = "li.dropdown.uui-profile-menu")
    public static UIElement loggedInUser;
    @FindBy(css = ".logout")
    public static Button logoutButton;

    public static void open() {
        jdiHomePage.open();
    }

    public static void logoutUser() {
        loggedInUser.click();
        logoutButton.click();
    }
}