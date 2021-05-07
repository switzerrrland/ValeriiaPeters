package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "addition data")
    public static Object[][] additionData() {
        return new Object[][] {{2, 3}};
    }

    @DataProvider(name = "subtraction data")
    public static Object[][] subtractionData() {
        return new Object[][] {{100, 58}};
    }

    @DataProvider(name = "division data")
    public static Object[][] divisionData() {
        return new Object[][] {{3565, 23}};
    }

    @DataProvider(name = "multiplication data")
    public static Object[][] multiplicationData() {
        return new Object[][] {{60, 10}};
    }

}
