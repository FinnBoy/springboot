package net.awaken.springboot.repository.secondary;

import net.awaken.springboot.domain.secondary.RoleReadonly;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Finn Zhao
 * @version 2019-11-15
 */
public interface RoleReadonlyRepository extends CrudRepository<RoleReadonly, Long> {
}
