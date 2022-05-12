package pl.sterniczuk.conference.model.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sterniczuk.conference.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserByLogin(String login);
}
