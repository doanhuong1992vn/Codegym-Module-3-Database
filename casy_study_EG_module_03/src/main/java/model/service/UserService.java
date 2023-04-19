package model.service;

import case_study_Enjoy_Galaxy.model.builder.user_builder.IUserBuilder;
import case_study_Enjoy_Galaxy.model.builder.user_builder.UserConcreteBuilder;
import case_study_Enjoy_Galaxy.model.dao.iplm.UserDAO;
import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;
import case_study_Enjoy_Galaxy.model.utils.Converter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService {
    private static final UserService userService = new UserService();
    private static final List<User> userList = new ArrayList<>();
    private static final String PATH = "src\\case_study_Enjoy_Galaxy\\model\\data\\customer.csv";

    static {
        userList.addAll(UserDAO.getInstance().getAll());
    }

    private UserService() {
    }

    public static UserService getInstance() {
        return userService;
    }

    private String notification;
    private User currentUser;

    public void createCustomer(String fullName, String phoneNumber, String email, String password) {
        if (checkEmailAndPhoneNumberWhenSignUp(email, phoneNumber)) {
            notification = "Phone number or email is already registered";
        } else {
            IUserBuilder userBuilder = new UserConcreteBuilder()
                    .type("customer")
                    .fullName(fullName)
                    .phoneNumber(phoneNumber)
                    .email(email)
                    .password(password);
            User customer = userBuilder.build();
            userList.add(customer);
            UserDAO.getInstance().insertUser(customer);
            notification = "Successful registration. Welcome " + fullName + " to Enjoy Galaxy!";
        }
    }

    public void createStaff(String fullName, String phoneNumber, String email, String password, String education,
                            String jobTitle, double salary, Date birthday, String address) throws ParseException {
        if (checkEmailAndPhoneNumberWhenSignUp(email, phoneNumber)) {
            notification = "Phone number or email is already registered";
        } else {
            IUserBuilder userBuilder = new UserConcreteBuilder()
                    .type("staff")
                    .fullName(fullName)
                    .password(password)
                    .email(email)
                    .phoneNumber(phoneNumber)
                    .address(address)
                    .salary(salary)
                    .birthDay(birthday)
                    .education(education)
                    .jobTitle(jobTitle);
            User staff = userBuilder.build();
            userList.add(staff);
            UserDAO.getInstance().insertUser(staff);
            notification = "Successful registration for staff " + fullName + " to Enjoy Galaxy!";
        }
    }


    public boolean checkEmailAndPhoneNumberWhenSignUp(String email, String phoneNumber) {
        for (User user : userList) {
            if (email.equals(user.getEmail()) || phoneNumber.equals(user.getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkEmailAndPhoneNumber(String phoneNumberOrEmail) {
        for (User user : userList) {
            if (phoneNumberOrEmail.equals(user.getEmail()) || phoneNumberOrEmail.equals(user.getPhoneNumber())) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public String getNotification() {
        return notification;
    }

    public boolean isPaymentFailed(double price) {
        if (currentUser.getWallet() >= price) {
            final double AMOUNT_AFTER_PAYMENT = currentUser.getWallet() - price;
            currentUser.setWallet(AMOUNT_AFTER_PAYMENT);
            AdminService adminService = AdminService.getInstance();
            adminService.depositMoney(price);
            return false;
        }
        return true;
    }

    public void editFullName(String fullName) {
        currentUser.setFullName(fullName);
    }

    public void editPhoneNumber(String phoneNumber) {
        currentUser.setPhoneNumber(phoneNumber);
    }

    public void editEmail(String email) {
        currentUser.setEmail(email);
    }

    public void editPassword(String password) {
        currentUser.setPassword(password);
    }

    public void depositMoney(double money) {
        double amountAvailable = currentUser.getWallet();
        currentUser.setWallet(amountAvailable + money);
    }

    public String getWalletFormatOfUser() {
        return Converter.formatPrice(currentUser.getWallet());
    }

}
