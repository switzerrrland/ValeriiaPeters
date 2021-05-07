package ru.training.at.hw1;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.epam.tat.module4.Calculator;
import static org.testng.Assert.*;

public class AdditionTest {

    Calculator calculator = new Calculator();


    @Test(groups = {"first"}, dataProviderClass = DataProviders.class, dataProvider = "addition data")
    public void additionTest(long firstNum, long secondNum) {
       long actual = calculator.sum(firstNum, secondNum);
       long expected = 5;
       assertEquals(expected, actual);


    }
}
