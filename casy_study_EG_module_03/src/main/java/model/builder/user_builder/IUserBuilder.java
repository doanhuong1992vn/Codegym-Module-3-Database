package model.builder.user_builder;

import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;

import java.text.ParseException;
import java.util.Date;

public interface IUserBuilder {
    IUserBuilder id(long id);
    IUserBuilder type(String type);
    IUserBuilder fullName(String fullName);
    IUserBuilder phoneNumber(String phoneNumber);
    IUserBuilder email(String email);
    IUserBuilder password(String password);
    IUserBuilder education(String education);
    IUserBuilder jobTitle(String jobTitle);
    IUserBuilder salary(double salary);
    IUserBuilder birthDay(Date birthDay) throws ParseException;
    IUserBuilder address(String address);
    IUserBuilder wallet(double wallet);
    User build();
}
