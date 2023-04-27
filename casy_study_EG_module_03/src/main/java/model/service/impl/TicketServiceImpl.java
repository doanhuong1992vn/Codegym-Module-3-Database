package model.service.impl;

import model.builder.ticket_builder.ITicketBuilder;
import model.builder.ticket_builder.TicketConcreteBuilder;
import model.dao.iplm.SeatDAO;
import model.dao.iplm.TicketDAO;
import model.domain.Ticket;
import model.domain.seat.Seat;
import model.domain.users.User;
import model.dto.DomainDTO;
import model.service.ITicketService;

import java.util.*;

public class TicketServiceImpl implements ITicketService {
    public static ITicketService getTicketService(){
        return new TicketServiceImpl();
    }

    @Override
    public List<DomainDTO> getDomainDTOList(String[] idSeats, long idUser, DomainDTO domainDTO) {
        List<DomainDTO> domainDTOList = new ArrayList<>();
        for (String strIdSeat : idSeats) {
            long idSeat = Long.parseLong(strIdSeat);
            Seat seat = SeatDAO.getSeatDAO().getSeatById(idSeat);
            seat.setEmpty(false);
            SeatDAO.getSeatDAO().updateSeat(idSeat);
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
            DomainDTO cloneDomainDTO = domainDTO.clone();
            cloneDomainDTO.setSeat(seat);
            cloneDomainDTO.setTicket(ticket);
            domainDTOList.add(cloneDomainDTO);
        }
        return domainDTOList;
    }
}
