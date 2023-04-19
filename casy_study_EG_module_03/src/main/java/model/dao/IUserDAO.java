package model.dao;

import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;

import java.util.List;

public interface IUserDAO {
    void insertUser(User user);
    List<User> getAll();
}
