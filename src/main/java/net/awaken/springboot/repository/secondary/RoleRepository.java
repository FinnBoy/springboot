package net.awaken.springboot.repository.secondary;

import net.awaken.springboot.domain.secondary.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Finn Zhao
 * @version 2019-11-15
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
}
