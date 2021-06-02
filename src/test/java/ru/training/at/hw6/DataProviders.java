package ru.training.at.hw6;

import org.testng.annotations.DataProvider;
import java.util.List;
import static ru.training.at.hw6.DataSetReader.getTestDataJsonAsList;

public class DataProviders {

    @DataProvider(name = "metals and colors")
    public Object[][] metalsAndColors() {
        List<DataSetReader> dataList = getTestDataJsonAsList();
        return dataList.stream()
                .map(data -> new DataSetReader[]{data})
                .toArray(Object[][]::new);
    }
}