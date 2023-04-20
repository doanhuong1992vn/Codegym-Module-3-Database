package model.dao;


import model.entity.users.User;

import java.util.List;

public interface IUserDAO {
    void insert(User user);
    List<User> getAll();
}
