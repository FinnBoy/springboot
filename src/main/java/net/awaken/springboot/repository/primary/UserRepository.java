package net.awaken.springboot.repository.primary;

import net.awaken.springboot.domain.primary.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Finn Zhao
 * @version 2019-11-15
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
