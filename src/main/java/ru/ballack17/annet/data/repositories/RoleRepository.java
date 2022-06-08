package ru.ballack17.annet.data.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ballack17.annet.data.entities.Role;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {

    Optional<Role> findRoleByName(String name);
}
