package model.service;

import model.dto.DomainDTO;

public interface ICinemaService {
    DomainDTO getDomainDTO(long idShowtime);
}
