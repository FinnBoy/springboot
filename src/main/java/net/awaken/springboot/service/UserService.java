package net.awaken.springboot.service;

import net.awaken.springboot.domain.secondary.RoleReadonly;

/**
 * @author Finn Zhao
 * @version 2019-11-15
 */
public interface UserService {

    void saveUser(String name, String email);

    void saveRole(String name);

    RoleReadonly getRole(Long id);
}
