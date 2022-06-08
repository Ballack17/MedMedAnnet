package ru.ballack17.annet.data.Dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PersonalStatisticDto {

    private String login;

    private double correctAnswers;

    private double betterThenYou;

    private double worseThenYou;

}
