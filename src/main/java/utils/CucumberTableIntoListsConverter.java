package utils;

import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.List;

public class CucumberTableIntoListsConverter {
    List<String> numbersColumnList = new ArrayList<>();
    List<String> usersColumnList = new ArrayList<>();
    List<String> descriptionsColumnList = new ArrayList<>();

    public List<String> getNumbersColumn(DataTable table) {
        List<List<String>> expectedTableValues = table.asLists();
        for (int i = 1; i < expectedTableValues.size(); i++) {
            numbersColumnList.add((expectedTableValues.get(i).get(0)));
        }
        return numbersColumnList;
    }

    public List<String> getUsersColumn(DataTable table) {
        List<List<String>> expectedTableValues = table.asLists();
        for (int i = 1; i < expectedTableValues.size(); i++) {
            usersColumnList.add((expectedTableValues.get(i).get(1)));
        }
        return usersColumnList;
    }

    public List<String> getDescriptionsColumn(DataTable table) {
        List<List<String>> expectedTableValues = table.asLists();
        for (int i = 1; i < expectedTableValues.size(); i++) {
            descriptionsColumnList.add((expectedTableValues.get(i).get(2)));
        }
        return descriptionsColumnList;
    }

    public List<String> getDropdownValuesColumn(DataTable table) {
        List<String> initialTable = table.asList();
        List<String> expectedValues = new ArrayList<>(initialTable.subList(1, initialTable.size()));
        return expectedValues;
    }
}