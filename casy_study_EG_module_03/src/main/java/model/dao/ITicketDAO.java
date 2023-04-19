package model.dao;

import case_study_Enjoy_Galaxy.model.entity.Ticket;

import java.util.List;

public interface ITicketDAO {
    List<Ticket> getAll();
    void insertTicket(Ticket ticket);
}
