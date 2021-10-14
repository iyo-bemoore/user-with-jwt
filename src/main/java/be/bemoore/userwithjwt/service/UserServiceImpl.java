package be.bemoore.userwithjwt.service;

import be.bemoore.userwithjwt.models.Role;
import be.bemoore.userwithjwt.models.User;
import be.bemoore.userwithjwt.repo.RoleRepository;
import be.bemoore.userwithjwt.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor // Dependency injection
@Transactional // Class used with db
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public User saveUser(User user) {
        log.info("Saving new user to Database");
        return userRepository.save((user));
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role to Database");
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
     log.info("Adding Role to User");
     User user = userRepository.findByUsername(username);
     Role role = roleRepository.findByName(roleName);
     user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("getting user {} from DB",username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
