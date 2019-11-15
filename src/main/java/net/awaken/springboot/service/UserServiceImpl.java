package net.awaken.springboot.service;

import net.awaken.springboot.configuration.PrimaryBeanName;
import net.awaken.springboot.configuration.SecondaryBeanName;
import net.awaken.springboot.domain.primary.User;
import net.awaken.springboot.domain.secondary.Role;
import net.awaken.springboot.repository.primary.UserRepository;
import net.awaken.springboot.repository.secondary.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Finn Zhao
 * @version 2019-11-15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional(value = PrimaryBeanName.TRANSACTION_MANAGER)
    public void saveUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
    }

    @Transactional(value = SecondaryBeanName.TRANSACTION_MANAGER)
    public Role getRole(Long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        return optionalRole.get();
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
