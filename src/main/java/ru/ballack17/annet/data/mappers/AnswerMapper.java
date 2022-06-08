package ru.ballack17.annet.data.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.ballack17.annet.data.Dto.AnswerDto;
import ru.ballack17.annet.data.entities.Answer;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AnswerMapper {

    Answer toAnswer(AnswerDto answerDto);

    List<Answer> toAnswer(List<AnswerDto> answerDto);

}
