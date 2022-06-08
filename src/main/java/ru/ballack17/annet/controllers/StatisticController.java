package ru.ballack17.annet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ballack17.annet.configs.utils.JwtTokenUtil;
import ru.ballack17.annet.data.Dto.PersonalStatisticDto;
import ru.ballack17.annet.data.entities.Questionnaire;
import ru.ballack17.annet.services.PersonalStatisticService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/your_result")
public class PersonalStatisticController {

    private final PersonalStatisticService personalStatisticService;
    private final JwtTokenUtil jwtTokenUtil;

    @GetMapping("statistic")
    public PersonalStatisticDto myStatistic(HttpServletRequest request) {
        return personalStatisticService.getPersonalStatistic(jwtTokenUtil.getNameFromToken(request));
    }

    @GetMapping("answers")
    public List<Questionnaire> myAnswers(HttpServletRequest request) {
        return personalStatisticService.getMyAnswers(jwtTokenUtil.getNameFromToken(request));
    }

}
