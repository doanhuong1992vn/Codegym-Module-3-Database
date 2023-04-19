package model.entity.users;

import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;
import case_study_Enjoy_Galaxy.model.utils.Converter;

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
    @Override
    public String toString() {
        return String.format("""
                Họ tên admin: %s
                SĐT: %s
                Email: %s
                Tài khoản: %s""",
                getFullName(),
                getPhoneNumber(),
                getEmail(),
                Converter.formatPrice(getWallet()));
    }
}
