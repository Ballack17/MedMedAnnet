package ru.ballack17.annet.data.mappers;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.ballack17.annet.data.Dto.QuestionDto;
import ru.ballack17.annet.data.Dto.QuestionForUserDto;
import ru.ballack17.annet.data.entities.Question;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question toQuestion(QuestionDto questionDto);

    List<QuestionForUserDto> toQuestionForUserDtoList(List<Question> question);

}
