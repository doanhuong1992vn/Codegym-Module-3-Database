package model.service;

import model.domain.Ticket;
import model.domain.seat.Seat;

import java.util.List;
import java.util.Map;

public interface ITicketService {
    List<String> getInfo(String[] idSeats);

    Map<Seat, Ticket> getSeatAndTicketMap(String[] idSeats, long idUser);
}
