package model.factory;

import case_study_Enjoy_Galaxy.model.entity.users.Admin;
import case_study_Enjoy_Galaxy.model.entity.users.Customer;
import case_study_Enjoy_Galaxy.model.entity.users.Staff;
import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;

import java.util.EventListener;

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
