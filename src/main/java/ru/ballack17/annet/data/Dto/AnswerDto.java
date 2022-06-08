package ru.ballack17.annet.data.Dto;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class AnswerDto {

    @NonNull
    private String answerText;

    @NonNull
    private Boolean isCorrect;

    @NonNull
    private UUID questionId;

}
