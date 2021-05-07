package ru.training.at.hw1;

import org.testng.annotations.Test;
import com.epam.tat.module4.Calculator;
import static org.testng.Assert.*;

public class DivisionTest {
    Calculator calculator = new Calculator();

    @Test(groups = "second", dataProviderClass = DataProviders.class,
            dataProvider = "division data")
    public void divisionTest(long firstNum, long secondNum) {
        long actual = calculator.div(firstNum, secondNum);
        long expected = 155;
        assertEquals(actual, expected);
    }
}
