package model.service.impl;

import model.service.ITicketService;

import java.util.List;

public class TicketServiceImpl implements ITicketService {
    public static ITicketService getTicketService(){
        return new TicketServiceImpl();
    }
    @Override
    public List<String> getInfo(String[] idSeats) {
        return null;
    }
}
