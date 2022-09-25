package ru.practicum.diplom_3.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    private static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    private final By NAME_INPUT = By.xpath("//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/input[1]");
    private final By EMAIL_INPUT = By.xpath("//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[2]/div[1]/div[1]/input[1]");
    private final By PASSWORD_INPUT = By.xpath("//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/input[1]");
    private final By REGISTRATION_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By LOGIN_LINK = By.linkText("Войти");
    private final By ERROR_MESSAGE_INVALID_PASSWORD = By.xpath(".//p[text()='Некорректный пароль']");
    private final By REGISTRATION_HEADER = By.xpath(".//h2[text()='Регистрация']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage open() {
        DRIVER.get(REGISTER_PAGE_URL);
        return this;
    }

    public RegistrationPage clickOnName() {
        DRIVER.findElement(NAME_INPUT).click();
        return this;
    }

    public RegistrationPage clickOnEmail() {
        DRIVER.findElement(EMAIL_INPUT).click();
        return this;
    }

    public RegistrationPage clickOnPassword() {
        DRIVER.findElement(PASSWORD_INPUT).click();
        return this;
    }

    public RegistrationPage enterName(String data) {
        DRIVER.findElement(NAME_INPUT).sendKeys(data);
        return this;
    }

    public RegistrationPage enterEmail(String data) {
        DRIVER.findElement(EMAIL_INPUT).sendKeys(data);
        return this;
    }

    public RegistrationPage enterPassword(String data) {
        DRIVER.findElement(PASSWORD_INPUT).sendKeys(data);
        return this;
    }

    public LoginPage clickOnLoginLink() {
        DRIVER.findElement(LOGIN_LINK).click();
        return new LoginPage(DRIVER);
    }

    public LoginPage clickOnRegistrationButton() {
        DRIVER.findElement(REGISTRATION_BUTTON).click();
        return new LoginPage(DRIVER);
    }

    public RegistrationPage clickOutsideTheField() {
        DRIVER.findElement(REGISTRATION_HEADER).click();
        return this;
    }

    public boolean isErrorMessageInvalidPasswordDisplayed() {
        return DRIVER.findElement(ERROR_MESSAGE_INVALID_PASSWORD).isDisplayed();
    }
}
