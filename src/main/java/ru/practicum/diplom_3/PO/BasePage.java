package ru.practicum.diplom_3.PO;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected final WebDriver DRIVER;

    public BasePage(WebDriver driver) {
        this.DRIVER = driver;
    }
}
