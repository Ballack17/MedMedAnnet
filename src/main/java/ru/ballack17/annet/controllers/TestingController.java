package ru.ballack17.annet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ballack17.annet.data.Dto.QuestionForUserDto;
import ru.ballack17.annet.services.TestingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/get_test")
public class TestingController {

    private final TestingService testingService;

    @GetMapping
    public List<QuestionForUserDto> getTest() {
        return testingService.createTest();
    }
}
