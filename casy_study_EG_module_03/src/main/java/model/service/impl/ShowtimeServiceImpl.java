package model.service.impl;

import model.builder.showtime_builder.IShowtimeBuilder;
import model.builder.showtime_builder.ShowtimeConcreteBuilder;
import model.dao.iplm.RoomDAO;
import model.dao.iplm.SeatDAO;
import model.dao.iplm.ShowtimeDAO;
import model.domain.Movie;
import model.domain.Showtime;
import model.domain.room.Room;
import model.domain.seat.Seat;
import model.factory.SeatFactory;
import model.service.IShowtimeService;
import model.utils.Converter;
import model.utils.Validation;

import java.text.ParseException;
import java.util.*;

public class ShowtimeServiceImpl implements IShowtimeService {
    static {
        Date startTimeOfLastShowtime = new Date();
        Date sevenDaysLater = Converter.convertTo7DaysLater(new Date());
        while (startTimeOfLastShowtime.before(sevenDaysLater)) {
            try {
                startTimeOfLastShowtime = autoAddShowtimeAndReturnLastShowtime(startTimeOfLastShowtime);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static Date autoAddShowtimeAndReturnLastShowtime(Date startTimeOfLastShowtime) throws ParseException {
        for (Room room : RoomDAO.getRoomDAO().getAll()) {
            Date newStartTime;
            Movie randomMovie = MovieServiceImpl.getMovieService().getRandomMovie();
            List<Showtime> showtimeList = ShowtimeDAO.getShowtimeDAO().getShowtimeList(room.getId(), "idRoom");
            showtimeList.sort(Comparator.comparingLong(Showtime::getTimeOfStartTime));
            if (!showtimeList.isEmpty()) {
                Showtime lastShowtime = showtimeList.get(showtimeList.size() - 1);
                Date endTimeOfLastShowtime = lastShowtime.getEndTime();
                startTimeOfLastShowtime = lastShowtime.getStartTime();
                Date sevenDaysLater = Converter.convertTo7DaysLater(new Date());
                if (startTimeOfLastShowtime.after(sevenDaysLater)) {
                    continue;
                }
                newStartTime = Converter.getDateAfterCleaningTime(endTimeOfLastShowtime);
            } else {
                newStartTime = new Date();
            }
            if (!Validation.isInWorkingTimeOfMovieTheater(newStartTime)) {
                newStartTime = Converter.convertTo8h20AmOfDate(newStartTime);
            }
            Date endTime = Converter.getEndTimeBeforeCleaningTimeByShowtimeWithMovie(newStartTime, randomMovie);
            addShowtime(newStartTime, endTime, room, randomMovie);
            startTimeOfLastShowtime = (Date) newStartTime.clone();
        }
        return startTimeOfLastShowtime;
    }

    private static void addShowtime(Date startTime, Date endTime, Room room, Movie randomMovie) {
        if (endTime.after(new Date())) {
            IShowtimeBuilder showtimeBuilder = new ShowtimeConcreteBuilder()
                    .idMovie(randomMovie.getId())
                    .idRoom(room.getId())
                    .startTime(startTime)
                    .endTime(endTime);
            Showtime showtime = showtimeBuilder.build("demo");
            long idShowtime = ShowtimeDAO.getShowtimeDAO().insertShowtime(showtime);
            SeatServiceImpl.getSeatsAndInsert(idShowtime, room);
        }
    }

    public static IShowtimeService getShowtimeService() {
        return new ShowtimeServiceImpl();
    }

    @Override
    public Map<String, Set<Showtime>> getMapShowtime(long idMovie, Date date) throws ParseException {
        if (date.before(Converter.convertToBeginningOfDate(new Date()))) {
            return new HashMap<>();
        }
        return ShowtimeDAO.getShowtimeDAO().getMap(idMovie, date);
    }

    @Override
    public int getNumberShowtime(Map<String, Set<Showtime>> mapShowtime) {
        int number = 0;
        for (Map.Entry<String, Set<Showtime>> entry : mapShowtime.entrySet()) {
            for (Showtime showtime : entry.getValue()) {
                number++;
            }
        }
        return number;
    }
}
