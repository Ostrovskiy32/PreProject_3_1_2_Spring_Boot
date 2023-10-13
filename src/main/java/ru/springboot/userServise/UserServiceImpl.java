package ru.springboot.userServise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.springboot.userModel.User;
import ru.springboot.userRepositories.UserRepositories;

import java.util.List;
@Service
@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public class UserServiceImpl implements UserService{
    private final UserRepositories userRepositories;
    @Autowired
    public UserServiceImpl(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositories.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userRepositories.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userRepositories.addUser(user);
    }

    @Override
    public void removeUser(long id) {
        userRepositories.removeUser(id);
    }

    @Override
    public void updateUser(User user) {
        userRepositories.updateUser(user);
    }
}
