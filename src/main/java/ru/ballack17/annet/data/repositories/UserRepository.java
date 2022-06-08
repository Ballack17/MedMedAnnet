package ru.ballack17.annet.data.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.ballack17.annet.data.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    Optional<User> findUserByLogin(String login);

    Boolean existsByLogin(String login);

    List<User> findAll();

    @Query("select count(*) from med_annet.user u where u.role_id = :role_id")
    int countAllByRole(@Param("role_id") UUID uuid);

    @Query("select count(*) from med_annet.user")
    int countAll();

}
