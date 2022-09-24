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
import ru.practicum.diplom_3.PO.ForgotPasswordPage;
import ru.practicum.diplom_3.PO.MainPage;
import ru.practicum.diplom_3.PO.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BasePageChromeSettings {
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
    @DisplayName("Login via Login button")
    @Description("Verify that login is successful in case registration form was opened by clicking on Log In button")
    public void loginViaLoginButton() {
        boolean isMainPageDisplayed = new MainPage(driver)
                .open()
                .clickOnLoginButton()
                .waitUntilLoginPageIsDisplayed()
                .enterEmail(user.getEmail())
                .clickOnPassword()
                .enterPassword(user.getPassword())
                .clickOnLoginButton()
                .waitUntilMainPageIsDisplayed()
                .isMainPageHeaderDisplayed();

        assertTrue("Main page is not displayed: ", isMainPageDisplayed);
    }

    @Test
    @DisplayName("Login via Sign In button")
    @Description("Verify that login is successful in case registration form was opened by clicking on Sign In button")
    public void loginViaSignInButton() {
        boolean isMainPageDisplayed = new MainPage(driver)
                .open()
                .clickOnSignInButtonWhenNotLoggedIn()
                .waitUntilLoginPageIsDisplayed()
                .clickOnEmail()
                .enterEmail(user.getEmail())
                .clickOnPassword()
                .enterPassword(user.getPassword())
                .clickOnLoginButton()
                .waitUntilMainPageIsDisplayed()
                .isMainPageHeaderDisplayed();

        assertTrue("Main page is not displayed: ", isMainPageDisplayed);
    }

    @Test
    @DisplayName("Login via Registration link")
    @Description("Verify that login is successful in case registration form was opened by clicking on Registration link")
    public void loginViaRegistrationLink() {
        boolean isMainPageDisplayed = new RegistrationPage(driver)
                .open()
                .clickOnLoginLink()
                .waitUntilLoginPageIsDisplayed()
                .clickOnEmail()
                .enterEmail(user.getEmail())
                .clickOnPassword()
                .enterPassword(user.getPassword())
                .clickOnLoginButton()
                .waitUntilMainPageIsDisplayed()
                .isMainPageHeaderDisplayed();

        assertTrue("Main page is not displayed: ", isMainPageDisplayed);
    }

    @Test
    @DisplayName("Login via Login link")
    @Description("Verify that login is successful in case registration form was opened by clicking on Log In link on Forgot Password page")
    public void loginViaLoginLink() {
        boolean isMainPageDisplayed = new ForgotPasswordPage(driver)
                .open()
                .clickOnLoginLink()
                .waitUntilLoginPageIsDisplayed()
                .clickOnEmail()
                .enterEmail(user.getEmail())
                .clickOnPassword()
                .enterPassword(user.getPassword())
                .clickOnLoginButton()
                .waitUntilMainPageIsDisplayed()
                .isMainPageHeaderDisplayed();

        assertTrue("Main page is not displayed: ", isMainPageDisplayed);
    }

    @After
    public void deleteTestData() {
        ValidatableResponse response = userClient.login(UserCredentials.from(user));
        accessToken = response.extract().path("accessToken");
        userClient.delete(accessToken);
    }
}
