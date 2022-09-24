package ru.practicum.diplom_3.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {
    private static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    private final By ACCOUNT_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    private final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By BUN_TAB = By.xpath("//body/div[@id='root']/div[1]/main[1]/section[1]/div[1]/div[1]");
    private final By SAUCE_TAB = By.xpath("//body/div[@id='root']/div[1]/main[1]/section[1]/div[1]/div[2]");
    private final By INGREDIENTS_TAB = By.xpath("//body/div[@id='root']/div[1]/main[1]/section[1]/div[1]/div[3]");
    private final By MAIN_PAGE_HEADER = By.xpath("//header/nav[1]/div[1]/a[1]/*[1]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        DRIVER.get(MAIN_PAGE_URL);
        return this;
    }

    public MainPage clickOnBunTab() {
        DRIVER.findElement(BUN_TAB).click();
        return this;
    }

    public MainPage clickOnSauceTab() {
        DRIVER.findElement(SAUCE_TAB).click();
        return this;
    }

    public MainPage clickOnIngredientsTab() {
        DRIVER.findElement(INGREDIENTS_TAB).click();
        return this;
    }

    public LoginPage clickOnLoginButton() {
        DRIVER.findElement(LOGIN_BUTTON).click();
        return new LoginPage(DRIVER);
    }
    public String getSauceTabClass() {
        return DRIVER.findElement(SAUCE_TAB).getAttribute("class");
    }

    public String getBunTabClass() {
        return DRIVER.findElement(BUN_TAB).getAttribute("class");
    }

    public String getIngredientsTabClass() {
        return DRIVER.findElement(INGREDIENTS_TAB).getAttribute("class");
    }

    public LoginPage clickOnSignInButtonWhenNotLoggedIn() {
        DRIVER.findElement(ACCOUNT_BUTTON).click();
        return new LoginPage(DRIVER);
    }

    public ProfilePage clickOnSignInButtonWhenLoggedIn() {
        DRIVER.findElement(ACCOUNT_BUTTON).click();
        return new ProfilePage(DRIVER);
    }

    public MainPage waitUntilMainPageIsDisplayed() {
        new WebDriverWait(DRIVER, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(MAIN_PAGE_HEADER));
        return this;
    }

    public boolean isMainPageHeaderDisplayed() {
        return DRIVER.findElement(MAIN_PAGE_HEADER).isDisplayed();
    }
}
