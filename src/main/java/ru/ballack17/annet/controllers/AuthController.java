package ru.ballack17.annet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ballack17.annet.configs.utils.JwtTokenUtil;
import ru.ballack17.annet.data.Dto.UserDto;
import ru.ballack17.annet.services.UserService;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/1")
    public ResponseEntity<?> createAuthToken(@RequestBody UserDto userDto) {
        UserDetails userDetails = userService.loadUserByUsername(userDto.getLogin());
        return new ResponseEntity<>("all cool", HttpStatus.ACCEPTED);
    }

}
