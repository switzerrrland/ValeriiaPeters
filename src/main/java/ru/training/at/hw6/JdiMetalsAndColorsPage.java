package ru.training.at.hw6;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;

import java.util.List;
import java.util.stream.Collectors;

@Url("/metals-colors.html")
public class JdiMetalsAndColorsPage extends WebPage {
    MetalAndColorsForm metalAndColorsForm;
    @Css("div.info-panel-section ul.panel-body-list.results li")
    public WebList resultList;

    public void selectElements(DataSetReader data) {
        metalAndColorsForm.fill(data);
        metalAndColorsForm.submit();
    }

    public List<String> getResultsAsList() {
        List<String> result = resultList.stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
        System.out.println("actual: " + result);
        return result;
    }
}