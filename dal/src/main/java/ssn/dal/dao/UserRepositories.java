package ssn.dal.dao;

import org.springframework.data.repository.CrudRepository;
import ssn.dal.model.User;

import java.util.Optional;

public interface UserRepositories extends CrudRepository<User, Long> {
    Optional<User> findByLoginAndDeletedFalse(String login);
}
