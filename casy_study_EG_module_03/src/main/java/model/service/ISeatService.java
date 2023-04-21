package model.service;

import model.entity.seat.Seat;

import java.util.List;

public interface ISeatService {
    Seat[][] getSeatsByIdShowtime(long id);
}
