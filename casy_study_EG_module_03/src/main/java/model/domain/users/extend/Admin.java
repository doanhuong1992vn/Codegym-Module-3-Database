package model.domain.users.extend;

import model.domain.users.User;

public class Admin extends User {
    private static final Admin ADMIN = new Admin(
            "ADMIN",
            "Đoàn Hưởng",
            "0888442448",
            "huong@gmail.com",
            "123");

    public Admin(String type, String fullName, String phoneNumber, String email, String password) {
        super(type, fullName, phoneNumber, email, password);
    }

    public static Admin getInstance() {
        return ADMIN;
    }
}
