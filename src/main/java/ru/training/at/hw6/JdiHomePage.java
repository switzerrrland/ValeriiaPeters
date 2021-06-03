package ru.training.at.hw6;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import entities.User;

public class JdiHomePage extends WebPage {
    @Css("#user-name")
    public Text userName;

    @Css("#user-icon")
    private Button userIcon;

    @Css("ul.uui-navigation.nav.navbar-nav.m-l8")
    private Menu headerMenu;

    private JdiLoginForm jdiLoginForm;

    public void login(User user) {
        userIcon.click();
        jdiLoginForm.login(user);
    }

    public void selectMetalsAndColorsPageFromHeaderMenu() {
        headerMenu.select("Metals & Colors");
    }
}