package model.domain.users.extend;

import model.domain.users.User;

public class Customer extends User {

    public Customer(String type, String fullName, String phoneNumber, String email, String password) {
        super(type, fullName, phoneNumber, email, password);
    }

    public Customer(long id, String type, String fullName, String phoneNumber, String email, String password, double wallet) {
        super(id, type, fullName, phoneNumber, email, password, wallet);
    }

//    public String toString() {
//        return String.format("""
//                Khách hàng: %s
//                SĐT: %s
//                Email: %s
//                Tài khoản: %s
//                Mã vé: %s""",
//                getFullName(),
//                getPhoneNumber(),
//                getEmail(),
//                Converter.formatPrice(getWallet()),
//                getTicketCode());
//    }
}
