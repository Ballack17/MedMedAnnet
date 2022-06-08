package ru.ballack17.annet.data.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDto {

    @NonNull
    private String login;

    @NonNull
    private String password;



}
