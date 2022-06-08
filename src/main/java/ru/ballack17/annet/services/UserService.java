package ru.ballack17.annet.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ballack17.annet.data.Dto.UserDto;
import ru.ballack17.annet.data.entities.User;
import ru.ballack17.annet.data.mappers.UserMapper;
import ru.ballack17.annet.data.repositories.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public void createUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        user.setId(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleId(roleService.findRoleByName("ROLE_USER").getId());
        user.setActive(true);
        user.setIsInsert(true);
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String login) {
        User user = findUserByLogin(login);
        user.setActive(false);
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public int getCountUsersByRole(String role_name) {
        return userRepository.countAllByRole(roleService
                .findRoleByName(role_name)
                .getId());
    }

    public int countAllUsers() {
        return userRepository.countAll();
    }

    public User findUserByLogin(String login) {
        return userRepository.findUserByLogin(login).orElseThrow(()-> new NoSuchElementException("There are no User with login: " + login));
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(login).orElseThrow();
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(roleService.findRoleById(user.getRoleId()).getName())));
    }


}
