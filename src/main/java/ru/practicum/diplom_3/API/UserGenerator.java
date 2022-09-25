package ru.practicum.diplom_3.API;

import com.github.javafaker.Faker;

public class UserGenerator {
    private static Faker faker = new Faker();

    public static User getUser() {
        return new User(faker.internet().emailAddress(), faker.internet().password(6,10), faker.name().firstName());
    }
}
