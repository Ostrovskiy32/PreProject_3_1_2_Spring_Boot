package ru.springboot.userRepositories;

import ru.springboot.userModel.User;

import java.util.List;

public interface UserRepositories {
    List<User> getAllUsers();
    User getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user);
}
