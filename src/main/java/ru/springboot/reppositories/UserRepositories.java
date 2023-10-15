package ru.springboot.reppositories;

import ru.springboot.model.User;

import java.util.List;

public interface UserRepositories {
    List<User> getAllUsers();
    User getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user);
}
