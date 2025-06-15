package ua.opnu.practice1_template.repository;

import org.springframework.data.repository.CrudRepository;
import ua.opnu.practice1_template.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
