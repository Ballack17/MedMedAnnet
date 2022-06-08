package ru.ballack17.annet.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ballack17.annet.data.entities.Role;
import ru.ballack17.annet.data.repositories.RoleRepository;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role findRoleByName(String name) {
        Role role = roleRepository.findRoleByName(name).orElseThrow(()-> new NoSuchElementException("That role are absent: " + name));
        return role;
    }

    public Role findRoleById (UUID uuid) {
        return roleRepository.findById(uuid).get();
    }
}
