package model.service;

import model.domain.Ticket;
import model.domain.users.User;

import java.util.List;

public interface ITicketService {
    List<String> getInfo(String[] idSeats);

    List<Ticket> getTickets(String[] idSeats, long idUser);
}
