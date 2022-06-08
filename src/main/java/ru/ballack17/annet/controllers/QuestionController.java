package ru.ballack17.annet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.ballack17.annet.data.Dto.QuestionDto;
import ru.ballack17.annet.services.QuestionService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/question")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping()
    public int addQuestion(@RequestBody QuestionDto questionDto) {
        questionService.addQuestion(questionDto);
        return HttpStatus.OK.value();
    }

    @DeleteMapping()
    public int deleteQuestion(@RequestBody UUID questionId) {
        questionService.deleteById(questionId);
        return HttpStatus.OK.value();
    }

}
