package ssn.dal.dao;

import org.springframework.data.repository.CrudRepository;
import ssn.dal.model.Group;

public interface GroupRepositories extends CrudRepository<Group, Long> {
}
