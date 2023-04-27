package model.service;

import model.domain.Ticket;
import model.domain.seat.Seat;
import model.dto.DomainDTO;

import java.util.List;
import java.util.Map;

public interface ITicketService {
    List<DomainDTO> getDomainDTOList(String[] idSeats, long idUser, DomainDTO domainDTO);
}
