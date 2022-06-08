package ru.ballack17.annet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ballack17.annet.data.Dto.AnswerDto;
import ru.ballack17.annet.services.AnswerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/answer")
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping
    public void addAnswer(@RequestBody AnswerDto answerDto) {
        answerService.addAnswer(answerDto);
    }

    @PostMapping("/addList")
    public int addAnswerList(@RequestBody List<AnswerDto> answerListDto) {
        answerService.addAnswerList(answerListDto);
        return HttpStatus.OK.value();
    }

}
