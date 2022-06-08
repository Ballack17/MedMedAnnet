package ru.ballack17.annet.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.ballack17.annet.configs.utils.JwtTokenUtil;
import ru.ballack17.annet.data.Dto.QuestionnaireDto;
import ru.ballack17.annet.services.QuestionnaireService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/test_passing")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public int addQuestionnaireAnswers(@RequestBody QuestionnaireDto questionnaireDto, HttpServletRequest request) {
        questionnaireService.addQuestionnaireAnswers(questionnaireDto, jwtTokenUtil.getNameFromToken(request));
        return HttpStatus.OK.value();
    }

}
