package ru.training.at.hw1;

import org.testng.annotations.Test;
import com.epam.tat.module4.Calculator;
import static org.testng.Assert.*;

public class SubtractionTest {
    Calculator calculator = new Calculator();

    @Test(groups = "first", dataProviderClass = DataProviders.class,
            dataProvider = "subtraction data")
    public void subtractionTest(long firstNum, long secondNum) {
        long actual = calculator.sub(firstNum, secondNum);
        long expected = 42;
        assertEquals(actual, expected);
    }
}