package ru.ballack17.annet.data.Dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class QuestionForUserDto {

    private UUID id;

    private String questionText;

    private Boolean isOpenedAnswer;

    private List<String> answers;

}
