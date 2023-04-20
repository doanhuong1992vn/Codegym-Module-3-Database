package model.service.impl;

import model.dao.iplm.UserDAO;
import model.entity.users.User;
import model.service.IUserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements IUserService {
    public static IUserService getInstance(){
        return new UserServiceImpl();
    }
    @Override
    public List<User> getAll() {
        return UserDAO.getInstance().getAll();
    }
}
