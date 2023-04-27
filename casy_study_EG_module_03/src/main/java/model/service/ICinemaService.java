package model.service;

import model.dto.DomainDTO;

import java.util.List;

public interface ICinemaService {
    DomainDTO getDomainDTO(long idShowtime);

    List<DomainDTO> getDomainDTOList(long idUser);
}
