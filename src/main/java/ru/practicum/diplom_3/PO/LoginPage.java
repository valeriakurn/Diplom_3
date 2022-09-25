package ru.practicum.diplom_3.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    private final By EMAIL_INPUT = By.xpath("//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/input[1]");
    private final By PASSWORD_INPUT = By.xpath("//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[2]/div[1]/div[1]/input[1]");
    private final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    private final By LOGIN_HEADER = By.xpath("//h2[contains(text(),'Вход')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        DRIVER.get(LOGIN_PAGE_URL);
        return this;
    }

    public LoginPage clickOnEmail() {
        DRIVER.findElement(EMAIL_INPUT).click();
        return this;
    }

    public LoginPage enterEmail(String name) {
        DRIVER.findElement(EMAIL_INPUT).sendKeys(name);
        return this;
    }

    public LoginPage clickOnPassword() {
        DRIVER.findElement(PASSWORD_INPUT).click();
        return this;
    }

    public LoginPage enterPassword(String name) {
        DRIVER.findElement(PASSWORD_INPUT).sendKeys(name);
        return this;
    }

    public MainPage clickOnLoginButton() {
        DRIVER.findElement(LOGIN_BUTTON).click();
        return new MainPage(DRIVER);
    }

    public LoginPage waitUntilLoginPageIsDisplayed() {
        new WebDriverWait(DRIVER, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_HEADER));
        return this;
    }

    public boolean isLoginPageHeaderDisplayed() {
        return DRIVER.findElement(LOGIN_HEADER).isDisplayed();
    }
}
