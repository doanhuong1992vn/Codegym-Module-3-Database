package model.service;

import model.domain.users.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();

    boolean register(String name, String phoneNumber, String email, String password);

    User login(String loginName, String password);
}
