package model.factory;


import model.entity.users.User;
import model.entity.users.extend.Admin;
import model.entity.users.extend.Customer;
import model.entity.users.extend.Staff;

public class UserFactory {
    private static final UserFactory userFactory = new UserFactory();

    private UserFactory() {
    }

    public static UserFactory getInstance() {
        return userFactory;
    }

    public User getUser(String type, String fullName, String phoneNumber, String email, String password) {
        if (type.equalsIgnoreCase("STAFF")) {
            return new Staff(type, fullName, phoneNumber, email, password);
        } else if (type.equalsIgnoreCase("CUSTOMER")) {
            return new Customer(type, fullName, phoneNumber, email, password);
        } else {
            return new Admin(type, fullName, phoneNumber, email, password);
        }
    }
}
