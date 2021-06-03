package ru.training.at.hw6;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import lombok.Data;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static utils.Constants.JSON_PATH;

@Data
public class DataSetReader {
    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public static List<String> getExpectedResultInString(DataSetReader data) {
        List<String> result = new ArrayList<>();

        int sum = data.getSummary().get(0) + data.getSummary().get(1);
        result.add("Summary: " + sum);

        StringBuilder elementsString = new StringBuilder("Elements: ");
        for (int i = 0; i < data.getElements().size(); i++) {
            elementsString.append(data.getElements().get(i)).append(", ");
        }
        result.add(elementsString.substring(0, elementsString.length() - 2));

        result.add("Color: " + data.getColor());
        result.add("Metal: " + data.getMetals());

        StringBuilder vegetableString = new StringBuilder("Vegetables: ");
        for (int i = 0; i < data.getVegetables().size(); i++) {
            vegetableString.append(data.getVegetables().get(i)).append(", ");
        }
        result.add(vegetableString.substring(0, vegetableString.length() - 2));

        return result;
    }

    public static List<DataSetReader> getTestDataJsonAsList() {
        List<DataSetReader> dataList = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(JSON_PATH)) {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
            GsonBuilder gsonBuilder = new GsonBuilder();

            Map<String, Object> map = gsonBuilder.create().fromJson(jsonReader, Object.class);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                DataSetReader data = new Gson().fromJson(entry.getValue().toString(),
                        DataSetReader.class);
                dataList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}