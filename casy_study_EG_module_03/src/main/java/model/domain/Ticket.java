package model.domain;


import model.utils.Converter;

import java.util.Date;

public class Ticket {
    private long id;
    private double price;
    private long idUser;
    private long idSeat;
    private Date timeBooking;
    private boolean isPaid;
    private Date timePayment;
    private boolean isChecked;

    public Ticket(long id, double price, long idUser, long idSeat, Date timeBooking, boolean isPaid, Date timePayment, boolean isChecked) {
        this.id = id;
        this.price = price;
        this.idUser = idUser;
        this.idSeat = idSeat;
        this.timeBooking = timeBooking;
        this.isPaid = isPaid;
        this.timePayment = timePayment;
        this.isChecked = isChecked;
    }

    public Ticket(double price, long idUser, long idSeat, Date timeBooking, boolean isPaid, Date timePayment, boolean isChecked) {
        this.price = price;
        this.idUser = idUser;
        this.idSeat = idSeat;
        this.timeBooking = timeBooking;
        this.isPaid = isPaid;
        this.timePayment = timePayment;
        this.isChecked = isChecked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }
    public String getPriceFormat() {
        return Converter.formatPrice(getPrice());
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(long idSeat) {
        this.idSeat = idSeat;
    }

    public Date getTimeBooking() {
        return timeBooking;
    }

    public void setTimeBooking(Date timeBooking) {
        this.timeBooking = timeBooking;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Date getTimePayment() {
        return timePayment;
    }

    public void setTimePayment(Date timePayment) {
        this.timePayment = timePayment;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
