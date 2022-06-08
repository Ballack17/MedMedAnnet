package ru.ballack17.annet.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ballack17.annet.data.Dto.PersonalStatisticDto;
import ru.ballack17.annet.data.entities.Questionnaire;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalStatisticService {

    private final QuestionnaireService questionnaireService;
    private final QuestionService questionService;
    private final AnswerService answerService;

    public double getPersonalCorrectPercentage(String login) {
        double correctCount = questionnaireService.personalCorrectPercentage(login);
        return correctCount / 5 * 100;
    }

    public double getPercentageBetterThenYou(String login) {
        double countBetterThenYou = questionnaireService.betterThenYou(login);
        return countBetterThenYou/questionnaireService.countAllPassed(5)*100;
    }

    public double getPercentageWorseThenYou(String login) {
        double countWorseThenYou = questionnaireService.worseThenYou(login);
        return countWorseThenYou / questionnaireService.countAllPassed(5) *100;
    }

    public PersonalStatisticDto getPersonalStatistic(String login) {
        PersonalStatisticDto personalStatisticDto = new PersonalStatisticDto();
        personalStatisticDto.setCorrectAnswers(getPersonalCorrectPercentage(login));
        personalStatisticDto.setBetterThenYou(getPercentageBetterThenYou(login));
        personalStatisticDto.setWorseThenYou(getPercentageWorseThenYou(login));
        personalStatisticDto.setLogin(login);
        return personalStatisticDto;
    }

    public List<Questionnaire> getMyAnswers(String login) {
        return questionnaireService.getPersonalAnswer(login);
    }

}
