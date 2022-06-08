package ru.ballack17.annet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ballack17.annet.configs.utils.JwtTokenUtil;
import ru.ballack17.annet.data.Dto.PersonalStatisticDto;
import ru.ballack17.annet.data.Dto.StatisticDto;
import ru.ballack17.annet.data.entities.Questionnaire;
import ru.ballack17.annet.services.PersonalStatisticService;
import ru.ballack17.annet.services.StatisticService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/statistic")
public class StatisticController {

    private final PersonalStatisticService personalStatisticService;
    private final StatisticService statisticService;
    private final JwtTokenUtil jwtTokenUtil;

    @GetMapping("my_stats")
    public PersonalStatisticDto myStatistic(HttpServletRequest request) {
        return personalStatisticService.getPersonalStatistic(jwtTokenUtil.getNameFromToken(request));
    }

    @GetMapping("my_answers")
    public List<Questionnaire> myAnswers(HttpServletRequest request) {
        return personalStatisticService.getMyAnswers(jwtTokenUtil.getNameFromToken(request));
    }

    @GetMapping("all_stats")
    public StatisticDto getAllStats () {
        return statisticService.createStatistic();
    }

}
