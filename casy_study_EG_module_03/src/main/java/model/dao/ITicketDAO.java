package model.dao;


import model.domain.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ITicketDAO {
    List<Ticket> getAll();
    long insertTicket(Ticket ticket);

    Ticket getTicket(ResultSet resultSet) throws SQLException;
}
