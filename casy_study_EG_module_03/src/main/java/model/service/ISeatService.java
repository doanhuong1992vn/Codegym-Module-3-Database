package model.service;

import model.domain.seat.Seat;

public interface ISeatService {
    Seat[][] getSeatArrayByIdShowtime(long id);
}
