package ru.practicum.diplom_3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.practicum.diplom_3.PO.MainPage;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BasePageChromeSettings {
    private final String ACTIVE_TAB_CLASS = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";

    @Test
    @DisplayName("Navigation to sauces by clicking on tab")
    @Description("Verify that navigation to sauces is possible by clicking on tab")
    public void navigateToSauceTab() {
        String sauceTabClass = new MainPage(driver)
                .open()
                .clickOnSauceTab()
                .getSauceTabClass();

        assertEquals("Sauce tab is not active: ", sauceTabClass, ACTIVE_TAB_CLASS);
    }

    @Test
    @DisplayName("Navigation to ingredients by clicking on tab")
    @Description("Verify that navigation to ingredients is possible by clicking on tab")
    public void navigateToIngredientsTab() {
        String ingredientsTabClass = new MainPage(driver)
                .open()
                .clickOnIngredientsTab()
                .getIngredientsTabClass();

        assertEquals("Ingredients tab is not active: ", ingredientsTabClass, ACTIVE_TAB_CLASS);
    }

    @Test
    @DisplayName("Navigation to buns by clicking on tab")
    @Description("Verify that navigation to buns is possible by clicking on tab")
    public void navigateToBunsTab() {
        String bunTabClass = new MainPage(driver)
                .open()
                .clickOnSauceTab()
                .clickOnBunTab()
                .getBunTabClass();

        assertEquals("Buns tab is not active: ", bunTabClass, ACTIVE_TAB_CLASS);
    }
}
