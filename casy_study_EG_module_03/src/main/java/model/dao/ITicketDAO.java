package model.dao;


import model.domain.Ticket;

import java.util.List;

public interface ITicketDAO {
    List<Ticket> getAll();
    long insertTicket(Ticket ticket);
}
