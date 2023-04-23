package model.service.impl;

import model.dao.iplm.CinemaDAO;
import model.dto.DomainDTO;
import model.service.ICinemaService;

public class CinemaServiceImpl implements ICinemaService {
    public static ICinemaService getCinemaService() {
        return new CinemaServiceImpl();
    }

    @Override
    public DomainDTO getDomainDTO(long idShowtime) {
        return CinemaDAO.getInstance().getDomainDTO(idShowtime);
    }
}
