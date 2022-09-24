package ru.practicum.diplom_3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.practicum.diplom_3.API.User;
import ru.practicum.diplom_3.API.UserClient;
import ru.practicum.diplom_3.API.UserCredentials;
import ru.practicum.diplom_3.API.UserGenerator;
import ru.practicum.diplom_3.PO.MainPage;

import static org.junit.Assert.assertTrue;

public class ProfileTest extends BasePageChromeSettings {
    private static User user;
    private static String accessToken;
    private static UserClient userClient;

    @Before
    public void setUser() {
        user = UserGenerator.getUser();
        userClient = new UserClient();
        userClient.register(user);
    }

    @Test
    @DisplayName("Profile can be opened by clicking on Sign In button")
    @Description("Verify that in case user is successfully authorized, redirect to the profile page is happened by clicking on Sign In button")
    public void redirectToProfile() {
        boolean isProfileDisplayed = new MainPage(driver)
                .open()
                .clickOnSignInButtonWhenNotLoggedIn()
                .waitUntilLoginPageIsDisplayed()
                .enterEmail(user.getEmail())
                .clickOnPassword()
                .enterPassword(user.getPassword())
                .clickOnLoginButton()
                .waitUntilMainPageIsDisplayed()
                .clickOnSignInButtonWhenLoggedIn()
                .waitUntilProfilePageIsDisplayed()
                .isProfilePageMenuDisplayed();

        assertTrue("Profile page is not displayed: ", isProfileDisplayed);
    }

    @Test
    @DisplayName("Constructor can be opened by clicking on Logo")
    @Description("Verify that in case user is successfully authorized, redirect to the constructor page is happened by clicking on Logo")
    public void redirectToConstructorFromLogo() {
        user = UserGenerator.getUser();
        userClient.register(user);

        boolean isConstructorDisplayed = new MainPage(driver)
                .open()
                .clickOnSignInButtonWhenNotLoggedIn()
                .waitUntilLoginPageIsDisplayed()
                .enterEmail(user.getEmail())
                .clickOnPassword()
                .enterPassword(user.getPassword())
                .clickOnLoginButton()
                .waitUntilMainPageIsDisplayed()
                .clickOnSignInButtonWhenLoggedIn()
                .waitUntilProfilePageIsDisplayed()
                .clickOnLogo()
                .waitUntilMainPageIsDisplayed()
                .isMainPageHeaderDisplayed();

        assertTrue("Main page is not displayed: ", isConstructorDisplayed);
    }

    @Test
    @DisplayName("Constructor can be opened by clicking on Constructor menu item")
    @Description("Verify that in case user is successfully authorized, redirect to the constructor page is happened by clicking on Constructor from menu")
    public void redirectToConstructorFromHeader() {
        user = UserGenerator.getUser();
        userClient.register(user);

        boolean isConstructorDisplayed = new MainPage(driver)
                .open()
                .clickOnSignInButtonWhenNotLoggedIn()
                .waitUntilLoginPageIsDisplayed()
                .enterEmail(user.getEmail())
                .clickOnPassword()
                .enterPassword(user.getPassword())
                .clickOnLoginButton()
                .waitUntilMainPageIsDisplayed()
                .clickOnSignInButtonWhenLoggedIn()
                .waitUntilProfilePageIsDisplayed()
                .clickOnConstructorMenu()
                .waitUntilMainPageIsDisplayed()
                .isMainPageHeaderDisplayed();

        assertTrue("Main page is not displayed: ", isConstructorDisplayed);
    }

    @Test
    @DisplayName("Log out via Exit")
    @Description("Verify that in case user is successfully authorized, Log out can be proceeded by clicking on Exit button")
    public void exitFromProfile() {
        user = UserGenerator.getUser();
        userClient.register(user);

        boolean isProfileDisplayed = new MainPage(driver)
                .open()
                .clickOnSignInButtonWhenNotLoggedIn()
                .waitUntilLoginPageIsDisplayed()
                .enterEmail(user.getEmail())
                .clickOnPassword()
                .enterPassword(user.getPassword())
                .clickOnLoginButton()
                .waitUntilMainPageIsDisplayed()
                .clickOnSignInButtonWhenLoggedIn()
                .waitUntilProfilePageIsDisplayed()
                .clickOnExitButton()
                .waitUntilLoginPageIsDisplayed()
                .isLoginPageHeaderDisplayed();

        assertTrue("Login page is not displayed: ", isProfileDisplayed);
    }

    @After
    public void deleteTestData() {
        ValidatableResponse response = userClient.login(UserCredentials.from(user));
        accessToken = response.extract().path("accessToken");
        userClient.delete(accessToken);
    }
}
