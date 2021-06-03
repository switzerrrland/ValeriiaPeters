package ru.training.at.hw6;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class MetalAndColorsForm extends Form<DataSetReader> {
    @FindBy(name = "custom_radio_odd")
    public RadioButtons oddRadioButtons;
    @FindBy(name = "custom_radio_even")
    public RadioButtons evenRadioButtons;
    @FindBy(css = "section[id = elements-checklist] input[type = checkbox]")
    public Checklist elementsCheckboxes;
    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown colorsDropdown;
    @JDropdown(root = "div[ui=combobox]",
            value = "input",
            list = "li",
            expand = ".caret")
    public Dropdown metalsDropdown;
    @JDropdown(root = "#vegetables",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown vegetablesDropdown;
    @FindBy(id = "submit-button")
    public Button submitFormButton;
    @FindBy(css = "#salad-dropdown > button > span")
    public Button vegetablesCaret;
    @FindBy(id = "g7")
    public Checkbox vegetableCheckbox;

    @Override
    public void fill(DataSetReader data) {
        oddRadioButtons.select(data.getSummary().get(0).toString());
        evenRadioButtons.select(data.getSummary().get(1).toString());
        for (String element : data.getElements()) {
            elementsCheckboxes.select(element);
        }
        metalsDropdown.select(data.getMetals());
        colorsDropdown.select(data.getColor());
        resetVegetablesCheckboxState();
        for (String vegetable : data.getVegetables()) {
            vegetablesDropdown.select(vegetable);
        }
    }

    public void resetVegetablesCheckboxState() {
        vegetablesCaret.click();
        vegetableCheckbox.click();
    }

    @Override
    public void submit() {
        submitFormButton.click();
    }
}