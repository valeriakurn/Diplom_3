package ru.practicum.diplom_3;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import ru.practicum.diplom_3.API.User;
import ru.practicum.diplom_3.API.UserClient;
import ru.practicum.diplom_3.API.UserCredentials;
import ru.practicum.diplom_3.API.UserGenerator;
import ru.practicum.diplom_3.PO.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BasePageChromeSettings {
    private static User user;
    private static String accessToken;
    private static UserClient userClient;
    Faker faker = new Faker();

    @Before
    public void setUpUser() {
        user = UserGenerator.getUser();
        userClient = new UserClient();
    }

    @Test
    @DisplayName("User can be registered")
    @Description("Verify that in case user is successfully registered, redirect to the login page is happened")
    public void registrationValidPassword() {
        boolean isLoginPageDisplayed = new RegistrationPage(driver)
                .open()
                .clickOnName()
                .enterName(user.getName())
                .clickOnEmail()
                .enterEmail(user.getEmail())
                .clickOnPassword()
                .enterPassword(user.getPassword())
                .clickOnRegistrationButton()
                .waitUntilLoginPageIsDisplayed()
                .isLoginPageHeaderDisplayed();

        ValidatableResponse response = userClient.login(UserCredentials.from(user));
        accessToken = response.extract().path("accessToken");
        userClient.delete(accessToken);

        assertTrue("Login page is not displayed: ", isLoginPageDisplayed);
    }

    @Test
    @DisplayName("Error message is shown in case of invalid password")
    @Description("Verify that in case password contains less than 6 symbols, error message is shown")
    public void registrationInvalidPassword() {
        boolean isErrorMessageDisplayed = new RegistrationPage(driver)
                .open()
                .clickOnName()
                .enterName(user.getName())
                .clickOnEmail()
                .enterEmail(user.getEmail())
                .clickOnPassword()
                .enterPassword(faker.internet().password(1,5))
                .clickOutsideTheField()
                .isErrorMessageInvalidPasswordDisplayed();

        assertTrue("Error message is not displayed: ", isErrorMessageDisplayed);
    }
}
