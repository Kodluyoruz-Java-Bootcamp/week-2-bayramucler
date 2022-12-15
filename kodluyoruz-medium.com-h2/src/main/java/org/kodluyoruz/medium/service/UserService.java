package org.kodluyoruz.medium.service;

import org.kodluyoruz.medium.dao.UserDao;
import org.kodluyoruz.medium.model.User;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public void createUser(User user){
        userDao.createUser(user);
    }



    public List<User> getAllUsers() {
        return userDao.findAllUsers();
    }

    public void printAllUsers() {
        getAllUsers().forEach(user -> System.out.println(user));
    }

}
