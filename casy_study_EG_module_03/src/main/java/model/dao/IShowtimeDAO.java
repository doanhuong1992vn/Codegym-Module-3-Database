package model.dao;


import model.domain.Showtime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IShowtimeDAO {
    long insertShowtime(Showtime showtime);
    List<Showtime> getAll();

    List<Showtime> getShowtimeList(long id, String type);

    Map<String, Set<Showtime>> getMap(long id, Date date);
    Showtime getShowtime(ResultSet resultSet) throws SQLException;
}
