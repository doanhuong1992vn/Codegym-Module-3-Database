package model.builder.user_builder;

import model.domain.users.User;
import model.domain.users.extend.Admin;
import model.domain.users.extend.Customer;
import model.domain.users.extend.Staff;

import java.util.Date;

public class UserConcreteBuilder implements IUserBuilder {
    private long id;
    private String type;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;
    private String education;
    private String jobTitle;
    private double salary;
    private Date birthDay;
    private String address;
    private double wallet;

    @Override
    public IUserBuilder type(String type) {
        this.type = type;
        return this;
    }

    @Override
    public IUserBuilder wallet(double wallet) {
        this.wallet = wallet;
        return this;
    }

    @Override
    public IUserBuilder id(long id) {
        this.id = id;
        return this;
    }

    @Override
    public IUserBuilder fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Override
    public IUserBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public IUserBuilder email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public IUserBuilder password(String password) {
        this.password = password;
        return this;
    }

    @Override
    public IUserBuilder education(String education) {
        this.education = education;
        return this;
    }

    @Override
    public IUserBuilder jobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    @Override
    public IUserBuilder salary(double salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public IUserBuilder birthDay(Date birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    @Override
    public IUserBuilder address(String address) {
        this.address = address;
        return this;
    }

    @Override
    public User build() {
        if (type.equalsIgnoreCase("STAFF")) {
            return new Staff(id, type, fullName, phoneNumber, email, password, wallet, education, jobTitle, salary, birthDay, address);
        } else if (type.equalsIgnoreCase("CUSTOMER")) {
            return new Customer(id, type, fullName, phoneNumber, email, password, wallet);
        } else {
            return new Admin(type, fullName, phoneNumber, email, password);
        }
    }

    @Override
    public User buildInsert() {
        return new Customer(type, fullName, phoneNumber, email, password);
    }
}
