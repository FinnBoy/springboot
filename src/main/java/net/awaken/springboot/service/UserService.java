package net.awaken.springboot.service;

import net.awaken.springboot.domain.secondary.Role;

/**
 * @author Finn Zhao
 * @version 2019-11-15
 */
public interface UserService {

    void saveUser(String name, String email);

    Role getRole(Long id);
}
