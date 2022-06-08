package ru.ballack17.annet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.ballack17.annet.data.Dto.UserDto;
import ru.ballack17.annet.data.entities.User;
import ru.ballack17.annet.services.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("registration")
public class RegistrationController {

    private final UserService userService;

    @PostMapping
    public int registration(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return HttpStatus.OK.value();
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
