package ru.springboot.userRepositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Repository;
import ru.springboot.userModel.User;

import java.util.List;
@Repository
public class UserRepositoriesImpl implements UserRepositories{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
