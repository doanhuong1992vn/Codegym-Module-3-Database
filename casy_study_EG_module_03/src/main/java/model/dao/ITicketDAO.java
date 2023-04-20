package model.dao;


import model.entity.Ticket;

import java.util.List;

public interface ITicketDAO {
    List<Ticket> getAll();
    void insertTicket(Ticket ticket);
}
