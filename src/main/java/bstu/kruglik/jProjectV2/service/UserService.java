package bstu.kruglik.jProjectV2.service;


import bstu.kruglik.jProjectV2.models.Role;
import bstu.kruglik.jProjectV2.models.User;
import bstu.kruglik.jProjectV2.models.UserRole;
import bstu.kruglik.jProjectV2.service.interfaces.IUserService;
import bstu.kruglik.jProjectV2.repository.UserRepository;
import bstu.kruglik.jProjectV2.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public User saveUser(User user)
    {
        UserRole userRole = userRoleRepository.findByName(Role.ROLE_USER);
        user.setUserRole(userRole);
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }
    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findByLoginAndPassword(String login, String password){
        User user = findByLogin(login);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
    public boolean existsUserByLogin(String login)
    {
        return userRepository.existsUserByLogin(login);
    }
    public boolean existsUserByLoginAndPassword(String login, String password){
        return findByLoginAndPassword(login, password) != null;
    }
    @Override
    public User findById(Long id){
        return userRepository.getById(id);
    }

    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);

        if (user == null) {
            user.setActive(false);
            return false;
        }

        user.setActivationCode(null);
        user.setActive(true);
        userRepository.save(user);

        return true;
    }
}
