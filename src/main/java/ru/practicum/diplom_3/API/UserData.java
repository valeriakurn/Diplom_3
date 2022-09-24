package ru.practicum.diplom_3.API;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserData {
    private String email;
    private String name;

    public static UserData from(User user) {
        return new UserData(user.getEmail(), user.getName());
    }
}
