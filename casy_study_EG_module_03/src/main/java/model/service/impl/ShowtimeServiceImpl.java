package model.service.impl;

import model.builder.showtime_builder.IShowtimeBuilder;
import model.builder.showtime_builder.ShowtimeConcreteBuilder;
import model.dao.iplm.RoomDAO;
import model.dao.iplm.ShowtimeDAO;
import model.domain.Movie;
import model.domain.Showtime;
import model.domain.room.Room;
import model.service.IShowtimeService;
import model.utils.Converter;
import model.utils.Validation;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class ShowtimeServiceImpl implements IShowtimeService {
    static {
        System.out.println("BEGIN MOCKUP DATA");
        Date startTimeOfLastShowtime = new Date();
        Date sevenDaysLater = Converter.convertTo7DaysLater(new Date());
        Date beginOfToday = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        while (startTimeOfLastShowtime.before(sevenDaysLater)) {
            try {
                startTimeOfLastShowtime = autoAddShowtimeAndReturnLastShowtime(startTimeOfLastShowtime, beginOfToday);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static Date autoAddShowtimeAndReturnLastShowtime(Date startTimeOfLastShowtime, Date beginTime) throws ParseException {
        for (Room room : RoomDAO.getRoomDAO().getAll()) {
            System.out.println("MOCKUP DATA AT " + startTimeOfLastShowtime + " IN ROOM " + room.getName());
            Date newStartTime = new Date();;
            Movie randomMovie = MovieServiceImpl.getMovieService().getRandomMovie();
            List<Showtime> showtimeList = ShowtimeDAO.getShowtimeDAO().getShowtimeList(room.getId(), "idRoom");
            showtimeList.sort(Comparator.comparingLong(Showtime::getTimeOfStartTime));
            if (!showtimeList.isEmpty()) {
                Showtime lastShowtime = showtimeList.get(showtimeList.size() - 1);
                Date endTimeOfLastShowtime = lastShowtime.getEndTime();
                if (lastShowtime.getStartTime().after(beginTime)) {
                    startTimeOfLastShowtime = lastShowtime.getStartTime();
                }
                Date sevenDaysLater = Converter.convertTo7DaysLater(new Date());
                if (startTimeOfLastShowtime.after(sevenDaysLater)) {
                    continue;
                }
                if (endTimeOfLastShowtime.after(beginTime)) {
                    newStartTime = Converter.getDateAfterCleaningTime(endTimeOfLastShowtime);
                }
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
        IShowtimeBuilder showtimeBuilder = new ShowtimeConcreteBuilder()
                .idMovie(randomMovie.getId())
                .idRoom(room.getId())
                .startTime(startTime)
                .endTime(endTime);
        Showtime showtime = showtimeBuilder.build("demo");
        long idShowtime = ShowtimeDAO.getShowtimeDAO().insertShowtime(showtime);
        SeatServiceImpl.getSeatsAndInsert(idShowtime, room);
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
