package ru.training.at.hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.List;
import static entities.User.ROMAN;
import static ru.training.at.hw6.JdiSite.jdiMetalsAndColorsPage;

public class JdiSiteTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(dataProvider = "metals and colors", dataProviderClass = DataProviders.class)
    public void metalsAndColorsPageTest(DataSetReader data) {
        JdiSite.open();
        JdiSite.jdiHomePage.login(ROMAN);
        JdiSite.jdiHomePage.userName.is().text(ROMAN.getFullName());
        JdiSite.jdiHomePage.selectMetalsAndColorsPageFromHeaderMenu();
        jdiMetalsAndColorsPage.selectElements(data);

        List<String> actualResultsInStrings = jdiMetalsAndColorsPage.getResultsAsList();
        List<String> expectedResultsInString = DataSetReader
                .getExpectedResultInString(data);

        Assert.assertTrue(actualResultsInStrings.containsAll(expectedResultsInString));
    }

    @AfterMethod
    public void logout() {
        JdiSite.logoutUser();
    }
}