package ru.ballack17.annet.data.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.ballack17.annet.data.Dto.UserDto;
import ru.ballack17.annet.data.entities.User;

@Component
@Mapper (componentModel = "spring")
public interface UserMapper {

    User toUser(UserDto userDto);

    @InheritInverseConfiguration
    UserDto toUserDto(User user);
}
