package model.service.impl;

import model.builder.ticket_builder.ITicketBuilder;
import model.builder.ticket_builder.TicketConcreteBuilder;
import model.dao.iplm.SeatDAO;
import model.dao.iplm.TicketDAO;
import model.domain.Ticket;
import model.domain.seat.Seat;
import model.domain.users.User;
import model.service.ITicketService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketServiceImpl implements ITicketService {
    public static ITicketService getTicketService(){
        return new TicketServiceImpl();
    }
    @Override
    public List<String> getInfo(String[] idSeats) {
        return null;
    }

    @Override
    public List<Ticket> getTickets(String[] idSeats, long idUser) {
        List<Ticket> tickets = new ArrayList<>();
        for (String strIdSeat : idSeats) {
            long idSeat = Long.parseLong(strIdSeat);
            Seat seat = SeatDAO.getSeatDAO().getSeatById(idSeat);
            ITicketBuilder ticketBuilder = new TicketConcreteBuilder()
                    .price(seat.getPrice())
                    .idSeat(idSeat)
                    .idUser(idUser)
                    .isChecked(false)
                    .isPaid(false)
                    .timeBooking(new Date())
                    .timePayment(null);
            Ticket ticket = ticketBuilder.buildInsert();
            long idTicket = TicketDAO.getTicketDAO().insertTicket(ticket);
            ticket.setId(idTicket);
            tickets.add(ticket);
        }
        return tickets;
    }
}
