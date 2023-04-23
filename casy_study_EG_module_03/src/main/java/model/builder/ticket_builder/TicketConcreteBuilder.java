package model.builder.ticket_builder;


import model.domain.Ticket;

import java.util.Date;

public class TicketConcreteBuilder implements ITicketBuilder {
    private long id;
    private double price;
    private long idUser;
    private long idSeat;
    private Date timeBooking;
    private boolean isPaid;
    private Date timePayment;
    private boolean isChecked;

    @Override
    public ITicketBuilder id(long id) {
        this.id = id;
        return this;
    }

    @Override
    public ITicketBuilder idUser(long idUser) {
        this.idUser = idUser;
        return this;
    }

    @Override
    public ITicketBuilder idSeat(long idSeat) {
        this.idSeat = idSeat;
        return this;
    }

    @Override
    public ITicketBuilder price(double price) {
        this.price = price;
        return this;
    }

    @Override
    public ITicketBuilder timeBooking(Date timeBooking) {
        this.timeBooking = timeBooking;
        return this;
    }

    @Override
    public ITicketBuilder isPaid(boolean isPaid) {
        this.isPaid = isPaid;
        return this;
    }

    @Override
    public ITicketBuilder timePayment(Date timePayment) {
        this.timePayment = timePayment;
        return this;
    }

    @Override
    public ITicketBuilder isChecked(boolean isChecked) {
        this.isChecked = isChecked;
        return this;
    }

    @Override
    public Ticket build() {
        return new Ticket(id, price, idUser, idSeat, timeBooking, isPaid, timePayment, isChecked);
    }

    @Override
    public Ticket buildInsert() {
        return new Ticket(price, idUser, idSeat, timeBooking, isPaid, timePayment, isChecked);
    }
}
