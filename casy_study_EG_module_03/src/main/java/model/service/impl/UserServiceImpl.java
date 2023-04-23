package model.service.impl;

import model.builder.user_builder.IUserBuilder;
import model.builder.user_builder.UserConcreteBuilder;
import model.dao.iplm.UserDAO;
import model.domain.users.User;
import model.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    public static IUserService getUserService() {
        return new UserServiceImpl();
    }

    @Override
    public List<User> getAll() {
        return UserDAO.getUserDAO().getAll();
    }

    @Override
    public boolean register(String name, String phoneNumber, String email, String password) {
        IUserBuilder userBuilder = new UserConcreteBuilder()
                .type("customer").fullName(name).email(email).password(password).phoneNumber(phoneNumber);
        return UserDAO.getUserDAO().insert(userBuilder.buildInsert());
    }

    @Override
    public User login(String loginName, String password) {
        return UserDAO.getUserDAO().getUserLogged(loginName, password);
    }

}
