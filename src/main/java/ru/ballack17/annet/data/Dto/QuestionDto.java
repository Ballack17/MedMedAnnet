package ru.ballack17.annet.data.Dto;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class QuestionDto {

    @NonNull
    private String questionText;

    @NonNull
    private Boolean isOpenedAnswer;

}
