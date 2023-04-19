package model.entity.users.abstraction;

import case_study_Enjoy_Galaxy.model.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected final List<Ticket> ticketList = new ArrayList<>();
    protected long id;
    protected String type;
    protected String fullName;
    protected String phoneNumber;
    protected String email;
    protected String password;
    protected double wallet;

    protected User(String type, String fullName, String phoneNumber, String email, String password) {
        this.type = type;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public User(long id, String type, String fullName, String phoneNumber, String email, String password, double wallet) {
        this.id = id;
        this.type = type;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.wallet = wallet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTicketCode() {
        if (ticketList.isEmpty()) {
            return "Chưa mua vé";
        } else {
            StringBuilder ticketCodes = new StringBuilder();
            for (Ticket ticket : ticketList) {
                ticketCodes.append(ticket.getTicketCode()).append("\t");
            }
            return ticketCodes.toString();
        }
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void addTicket(Ticket ticket) {
        this.ticketList.add(ticket);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public abstract String toString();
}
