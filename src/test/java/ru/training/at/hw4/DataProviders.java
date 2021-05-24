package ru.training.at.hw4;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "elements indexes")
    public static Object[][] elementsIndexes() {
        return new Object[][] {{0, 2, 3, 3}};
    }
}
