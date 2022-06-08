package ru.ballack17.annet.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ballack17.annet.data.Dto.StatisticDto;

@Service
@RequiredArgsConstructor
public class StatisticService {

    private final UserService userService;
    private final QuestionnaireService questionnaireService;

    public StatisticDto createStatistic() {
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setPerfectTestUsersCount(questionnaireService.countAllIdealPass(5));
        statisticDto.setTestNotFinishedUserCount(questionnaireService.countAllProcessingTest(4));
        statisticDto.setTestFinishedUsersCount(questionnaireService.countAllPassed(5));
        statisticDto.setUsersCount(userService.countAllUsers());
        return statisticDto;
    }

}
