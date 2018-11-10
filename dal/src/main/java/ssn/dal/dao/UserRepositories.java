package ssn.dal.dao;

import org.springframework.data.repository.CrudRepository;
import ssn.dal.model.User;

public interface UserRepositories extends CrudRepository<User, Long> {
}
