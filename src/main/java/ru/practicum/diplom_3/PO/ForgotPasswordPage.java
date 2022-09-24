package ru.practicum.diplom_3.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {
    private static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private final By LOGIN_LINK = By.linkText("Войти");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public ForgotPasswordPage open() {
        DRIVER.get(MAIN_PAGE_URL);
        return this;
    }

    public LoginPage clickOnLoginLink() {
        DRIVER.findElement(LOGIN_LINK).click();
        return new LoginPage(DRIVER);
    }
}