package ru.ballack17.annet.data.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class JwtRequest {

    private String login;

    private String password;
}
