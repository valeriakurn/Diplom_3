package ru.practicum.diplom_3.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage {
    private static final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    private final By LOGO = By.xpath("//header/nav[1]/div[1]/a[1]/*[1]");
    private final By CONSTRUCTOR_MENU = By.xpath("//p[contains(text(),'Конструктор')]");
    private final By EXIT_BUTTON = By.xpath(".//button[text()='Выход']");
    private final By PROFILE_PAGE_MENU = By.xpath("//a[contains(text(),'Профиль')]");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage open() {
        DRIVER.get(PROFILE_PAGE_URL);
        return this;
    }

    public MainPage clickOnLogo() {
        DRIVER.findElement(LOGO).click();
        return new MainPage(DRIVER);
    }

    public MainPage clickOnConstructorMenu() {
        DRIVER.findElement(CONSTRUCTOR_MENU).click();
        return new MainPage(DRIVER);
    }

    public LoginPage clickOnExitButton() {
        DRIVER.findElement(EXIT_BUTTON).click();
        return new LoginPage(DRIVER);
    }

    public ProfilePage waitUntilProfilePageIsDisplayed() {
        new WebDriverWait(DRIVER, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(PROFILE_PAGE_MENU));
        return this;
    }

    public boolean isProfilePageMenuDisplayed() {
        return DRIVER.findElement(PROFILE_PAGE_MENU).isDisplayed();
    }
}
