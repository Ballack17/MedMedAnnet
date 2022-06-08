package ru.ballack17.annet.data.Dto;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class QuestionnaireDto {

    @NonNull
    private UUID question_id;

    @NonNull
    private String answerText;

}
