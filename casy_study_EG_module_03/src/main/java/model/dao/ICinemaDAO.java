package model.dao;


import model.domain.cinema.Cinema;
import model.dto.DomainDTO;

import java.util.List;

public interface ICinemaDAO {
    void insertMovieTheater(Cinema cinema);
    List<Cinema> getAll();

    DomainDTO getDomainDTO(long idShowtime);
}
