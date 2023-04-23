package model.dao;


import model.domain.users.User;

import java.util.List;

public interface IUserDAO {
    boolean insert(User user);
    List<User> getAll();
    User getUserLogged(String loginName, String password);
}
