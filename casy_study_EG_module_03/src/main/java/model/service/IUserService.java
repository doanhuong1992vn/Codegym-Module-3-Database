package model.service;

import model.entity.users.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
}
