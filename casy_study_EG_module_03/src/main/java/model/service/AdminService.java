package model.service;

import case_study_Enjoy_Galaxy.model.entity.users.Admin;

public class AdminService{
    private static final AdminService ADMIN_SERVICE = new AdminService();
    private AdminService() {
    }
    public static AdminService getInstance() {
        return ADMIN_SERVICE;
    }
    public void depositMoney(double money) {
        Admin admin = Admin.getInstance();
        double amountAvailable = admin.getWallet();
        admin.setWallet(amountAvailable + money);
    }

}
