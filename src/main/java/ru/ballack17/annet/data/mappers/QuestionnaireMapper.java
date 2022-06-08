package ru.ballack17.annet.data.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.ballack17.annet.data.Dto.QuestionnaireDto;
import ru.ballack17.annet.data.entities.Questionnaire;

@Component
@Mapper(componentModel = "spring")
public interface QuestionnaireMapper {

    Questionnaire toQuestionnaire(QuestionnaireDto questionnaireDto);

}
