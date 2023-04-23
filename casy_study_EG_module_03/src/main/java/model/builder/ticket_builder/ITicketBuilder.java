package model.builder.ticket_builder;


import model.domain.Ticket;

import java.util.Date;

public interface ITicketBuilder {
    ITicketBuilder id(long id);
    ITicketBuilder price(double price);
    ITicketBuilder idUser(long idUser);
    ITicketBuilder idSeat(long idSeat);
    ITicketBuilder timeBooking(Date timeBooking);
    ITicketBuilder isPaid(boolean isPaid);
    ITicketBuilder timePayment(Date timePayment);
    ITicketBuilder isChecked(boolean isChecked);

    Ticket build();
    Ticket buildInsert();
}
