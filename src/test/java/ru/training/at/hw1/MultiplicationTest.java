package ru.training.at.hw1;

import org.testng.annotations.Test;
import com.epam.tat.module4.Calculator;
import static org.testng.Assert.*;

public class MultiplicationTest {
    Calculator calculator = new Calculator();

    @Test(groups = "second", dataProviderClass = DataProviders.class,
            dataProvider = "multiplication data")
    public void multiplicationTest(long firstNum, long secondNum) {
        long actual = calculator.mult(firstNum, secondNum);
        long expected = 600;
        assertEquals(actual, expected);


    }
}
