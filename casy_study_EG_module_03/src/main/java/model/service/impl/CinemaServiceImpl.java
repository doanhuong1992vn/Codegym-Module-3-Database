package model.service.impl;

import model.dao.iplm.CinemaDAO;
import model.dto.DomainDTO;
import model.service.ICinemaService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CinemaServiceImpl implements ICinemaService {
    public static ICinemaService getCinemaService() {
        return new CinemaServiceImpl();
    }

    @Override
    public DomainDTO getDomainDTO(long idShowtime) {
        return CinemaDAO.getInstance().getDomainDTO(idShowtime);
    }

    @Override
    public List<DomainDTO> getDomainDTOList(long idUser) {
        List<DomainDTO> domainDTOList = CinemaDAO.getInstance().getDomainDTOList(idUser);
        domainDTOList.sort(Comparator.comparingLong(DomainDTO::getTimeOfStartTime));
        return domainDTOList;
    }
}
