package model.service;

import case_study_Enjoy_Galaxy.model.builder.showtime_builder.IShowtimeBuilder;
import case_study_Enjoy_Galaxy.model.builder.showtime_builder.ShowtimeConcreteBuilder;
import case_study_Enjoy_Galaxy.model.dao.iplm.MovieTheaterDAO;
import case_study_Enjoy_Galaxy.model.dao.iplm.RoomDAO;
import case_study_Enjoy_Galaxy.model.dao.iplm.SeatDAO;
import case_study_Enjoy_Galaxy.model.dao.iplm.ShowtimeDAO;
import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.Showtime;
import case_study_Enjoy_Galaxy.model.entity.Ticket;
import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Room;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;
import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;
import case_study_Enjoy_Galaxy.model.factory.SeatFactory;
import case_study_Enjoy_Galaxy.model.utils.Converter;
import case_study_Enjoy_Galaxy.model.utils.Validation;

import java.text.ParseException;
import java.util.*;

public class MovieTheaterService {
    private static final MovieTheaterService movieTheaterService = new MovieTheaterService();
    private static final List<MovieTheater> movieTheaterList = new ArrayList<>();
    private static String notification;

    static {
        movieTheaterList.addAll(MovieTheaterDAO.getInstance().getAll());
        for (MovieTheater movieTheater : movieTheaterList) {
            movieTheater.setCinemas(RoomDAO.getRoomDAO().getRoomListByIdMovieTheater(movieTheater.getId()));
            for (Room room : movieTheater.getRooms()) {
                List<Showtime> showtimeList = ShowtimeDAO.getShowtimeDAO().getShowtimeListByIdRoom(room.getId());
                for (Showtime showtime : showtimeList) {
                    Movie movie = MovieService.getInstance().getMovieById(showtime.getIdMovie());
                    addShowtime(showtime.getId(), movieTheater, room, movie, showtime.getShowtime(), showtime.getEndTime(), "SELECT");
                }
            }
        }
        Date dateToCheck = new Date();
        Date sevenDaysLater = Converter.convertTo7DaysLater(new Date());
        while (dateToCheck.before(sevenDaysLater)) {
            try {
                dateToCheck = autoAddShowtimeAndReturnLastShowtime(dateToCheck);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private MovieTheaterService() {
    }

    public static MovieTheaterService getInstance() {
        return movieTheaterService;
    }

    public static String getNotification() {
        return notification;
    }


    public static void addShowtime(int idMovieTheater, int idCinema, Date tempShowtime, int idMovie) {
        Movie movie = MovieService.getInstance().getMovieById(idMovie);
        if (tempShowtime.before(new Date())) {
            notification = "Không thể thêm suất chiếu vào quá khứ kekeke";
            return;
        }
        Date tempEndTime = Converter.getEndTimeBeforeCleaningTimeByShowtimeWithMovie(tempShowtime, movie);
        Date tempEndTimeAfterCleaningTime = Converter.getEndTimeAfterCleaningTime(tempEndTime);
        MovieTheater movieTheater = MovieTheaterService.getInstance().getMovieTheaterById(idMovieTheater);
        assert movieTheater != null;
        for (Room room : movieTheater.getRooms()) {
            if (room.getId() == idCinema) {
                if (!room.getShowtimeList().isEmpty()) {
                    for (Showtime showtime : room.getShowtimeList()) {
                        Date realShowtime = showtime.getShowtime();
                        Date realEndTime = Converter.getEndTimeAfterCleaningTime(showtime.getEndTime());
                        if (tempShowtime.after(realShowtime) && tempShowtime.before(realEndTime)) {
                            notification = String.format("Thêm không thành công vì suất chiếu bị trùng với " +
                                            "suất chiếu của phim %s từ %s tới %s tại phòng chiếu %s. " +
                                            "(Đã bao gồm 30 phút để vệ sinh phòng sau mỗi suất chiếu)",
                                    showtime.getMovie().getName(),
                                    Converter.getDateFormat24H(realShowtime),
                                    Converter.getDateFormat24H(realEndTime),
                                    showtime.getNameOfRoom());
                            return;
                        } else if (tempShowtime.before(realShowtime) && tempEndTimeAfterCleaningTime.after(realShowtime)) {
                            notification = String.format("Thêm không thành công vì không có đủ thời gian trống. " +
                                            "Phim %s có thời lượng %s phút nhưng lúc %s có suất chiếu của phim %s rồi. " +
                                            "(Sau mỗi suất chiếu phải có 30 phút để vệ sinh phòng nữa)",
                                    movie.getName(),
                                    movie.getMovieDuration(),
                                    Converter.getDateFormat24H(realShowtime),
                                    showtime.getMovie().getName());
                            return;
                        }
                    }
                }
                addShowtime(Showtime.getNewId(), movieTheater, room, movie, tempShowtime, tempEndTime, "INSERT");
                notification = String.format("Thêm thành công suất chiếu cho phim %s lúc %s " +
                                "tại phòng chiếu %s ở rạp %s",
                        movie.getName(),
                        Converter.getDateFormat24H(tempShowtime),
                        room.getName(),
                        movieTheater.getName());
                return;
            }
        }
    }

    private static Date autoAddShowtimeAndReturnLastShowtime(Date startTimeOfLastShowtime) throws ParseException {
        for (MovieTheater movieTheater : movieTheaterList) {
            for (Room room : movieTheater.getRooms()) {
                Date newShowtime;
                MovieService movieService = MovieService.getInstance();
                Movie randomMovie = movieService.getRandomMovie();
                List<Showtime> showtimeList = room.getShowtimeList();
                if (!showtimeList.isEmpty()) {
                    Showtime lastShowtime = showtimeList.get(showtimeList.size() - 1);
                    Date endTimeOfLastShowtime = lastShowtime.getEndTime();
                    startTimeOfLastShowtime = lastShowtime.getShowtime();
                    Date sevenDaysLater = Converter.convertTo7DaysLater(new Date());
                    if (startTimeOfLastShowtime.after(sevenDaysLater)) {
                        continue;
                    }
                    newShowtime = Converter.getEndTimeAfterCleaningTime(endTimeOfLastShowtime);
                } else {
                    newShowtime = new Date();
                }
                if (!Validation.isInWorkingTimeOfMovieTheater(newShowtime)) {
                    newShowtime = Converter.convertTo8hAmOfDate(newShowtime);
                }
                Date endTime = Converter.getEndTimeBeforeCleaningTimeByShowtimeWithMovie(newShowtime, randomMovie);
                addShowtime(Showtime.getNewId(), movieTheater, room, randomMovie, newShowtime, endTime, "INSERT");
                startTimeOfLastShowtime = (Date) newShowtime.clone();
            }
        }
        return startTimeOfLastShowtime;
    }

    private static void addShowtime(
            long id, MovieTheater movieTheater, Room room, Movie movie,
            Date startTime, Date endTime, String insertOrSelect) {
        if (endTime.after(new Date())) {
            IShowtimeBuilder showtimeBuilder = new ShowtimeConcreteBuilder()
                    .id(id)
                    .idMovieTheater(movieTheater.getId())
                    .movie(movie)
                    .addressMovieTheater(movieTheater.getAddress())
                    .nameMovieTheater(movieTheater.getName())
                    .nameRoom(room.getName())
                    .idRoom(room.getId())
                    .startTime(startTime)
                    .endTime(endTime)
                    .price(room.getPrice());
            Showtime showtime = showtimeBuilder.build();
            Seat[][] seats = new Seat[room.getRowSeat()][room.getColumnSeat()];

            if (insertOrSelect.equalsIgnoreCase("INSERT")) {
                ShowtimeDAO.getShowtimeDAO().insertShowtime(showtime);
                seats = SeatFactory.getInstance().getSeats(
                        room.getRowSeat(),
                        room.getColumnSeat(),
                        id);
                for (Seat[] rowSeat : seats) {
                    for (Seat seat : rowSeat) {
                        SeatDAO.getSeatDAO().insertSeat(seat);
                    }
                }
            } else { // if (insertOrSelect.equalsIgnoreCase("SELECT"))
                List<Seat> seatList = SeatDAO.getSeatDAO().getSeatsByIdShowtime(id);
                final String alphabet = "ABCDEFGHIJKLMNOP";
                for (Seat seat : seatList) {
                    String code = seat.getCode();
                    int indexRow = alphabet.indexOf(code.charAt(0));
                    int indexColumn = Integer.parseInt(code.substring(1)) - 1;
                    seats[indexRow][indexColumn] = seat;
                }
            }
            showtime.setSeats(seats);
            room.addShowtime(showtime);
        }
    }

    public List<MovieTheater> getMovieTheaterList() {
        return movieTheaterList;
    }

    public MovieTheater getMovieTheaterById(int idMovieTheater) {
        for (MovieTheater movieTheater : movieTheaterList) {
            if (movieTheater.getId() == idMovieTheater) {
                return movieTheater;
            }
        }
        return null;
    }

    public List<StringBuilder> getShowtimeListInDayByMovie(Movie movie, Date date) throws ParseException {
        List<StringBuilder> result = new ArrayList<>();
        for (MovieTheater movieTheater : movieTheaterList) {
            StringBuilder informationOfEachMovieTheater = new StringBuilder();
            int showtimeNumberOfEachMovieTheater = 0;
            for (Room room : movieTheater.getRooms()) {
                for (Showtime showtime : room.getShowtimeList()) {
                    Date nextDay = Converter.convertToBeginningOfNextDay(date);
                    if (showtime.getShowtime().after(date) && showtime.getShowtime().before(nextDay)
                            && movie.equals(showtime.getMovie())) {
                        ++showtimeNumberOfEachMovieTheater;
                        String showtimeFormat = Converter.getHourFormat24HByDate(showtime.getShowtime());
                        final String SHOWTIME =
                                String.format("\n\t\tPhòng chiếu %s có suất chiếu lúc: %s <ID SHOWTIME = %d>",
                                        room.getName(), showtimeFormat, showtime.getId());
                        informationOfEachMovieTheater.append(SHOWTIME);
                    }
                }
            }
            if (!informationOfEachMovieTheater.isEmpty()) {
                final String HEAD = String.format("Rạp %s (%s) có %d suất chiếu:",
                        movieTheater.getName(), movieTheater.getAddress(), showtimeNumberOfEachMovieTheater);
                informationOfEachMovieTheater.insert(0, HEAD);
                result.add(informationOfEachMovieTheater);
            }
        }
        return result;
    }

    public Map<Date, Integer> getShowtimeDateMapByMovie(Movie movie) throws ParseException {
        Map<Date, Integer> resultMap = new TreeMap<>(Comparator.comparingLong(Date::getTime));
        for (MovieTheater movieTheater : movieTheaterList) {
            for (Room room : movieTheater.getRooms()) {
                for (Showtime showtime : room.getShowtimeList()) {
                    boolean isShowtimeAfterNow = showtime.getShowtime().after(new Date());
                    if (movie.equals(showtime.getMovie()) && isShowtimeAfterNow) {
                        Date showtimeDate = Converter.convertToBeginningOfDate(showtime.getShowtime());
                        if (resultMap.isEmpty()) {
                            resultMap.put(showtimeDate, 1);
                        } else if (resultMap.containsKey(showtimeDate)) {
                            int showtimeNumber = resultMap.get(showtimeDate);
                            int newShowtimeNumber = showtimeNumber + 1;
                            resultMap.replace(showtimeDate, newShowtimeNumber);
                        } else {
                            resultMap.put(showtimeDate, 1);
                        }
                    }
                }
            }
        }
        return resultMap;
    }


    public Showtime getShowtimeById(int idShowtime) {
        for (MovieTheater movieTheater : movieTheaterList) {
            for (Room room : movieTheater.getRooms()) {
                for (Showtime showtime : room.getShowtimeList()) {
                    if (showtime.getId() == idShowtime) {
                        return showtime;
                    }
                }
            }
        }
        return null;
    }

    public void bookSeat(int idShowtime, Ticket ticket, boolean status) {
        Showtime showtime = getShowtimeById(idShowtime);
        String seatCode = ticket.getSeatCode();
        for (Seat[] rowOfSeats : showtime.getSeats()) {
            for (Seat seat : rowOfSeats) {
                if (seat.getCode().equals(seatCode)) {
                    seat.setEmpty(status);
                }
            }
        }
    }

    public StringBuilder getEmptySeats(Seat[][] seats) {
        StringBuilder informationOfSeats = new StringBuilder();
        StringBuilder emptySeats = new StringBuilder();
        for (Seat[] rowOfSeats : seats) {
            informationOfSeats.append(getInformationOfRowOfSeats(rowOfSeats));
            for (Seat seat : rowOfSeats) {
                if (seat.isEmpty()) {
                    emptySeats.append(seat).append("  ");
                }
            }
        }
        if (emptySeats.isEmpty()) {
            final String NOTICE_OF_FULL_SEATS = "Xin lỗi, suất chiếu này đã hết ghế trống. Vui lòng chọn suất chiếu khác";
            emptySeats.append(NOTICE_OF_FULL_SEATS);
            return emptySeats;
        }
        final String HEAD = "Các mã ghế còn trống: ";
        emptySeats.insert(0, HEAD);
        return informationOfSeats.append(emptySeats);
    }

    public static String getInformationOfRowOfSeats(Seat[] rowOfSeats) {
        final int SAMPLE_INDEX = 0;
        return String.format("Hàng %s là loại ghế %s dành cho %d người. Kiểu %s. Giá chỉ %s chưa tính phụ thu\n",
                rowOfSeats[SAMPLE_INDEX].getCode().charAt(SAMPLE_INDEX),
                rowOfSeats[SAMPLE_INDEX].getSeatType(),
                rowOfSeats[SAMPLE_INDEX].getCapacity(),
                rowOfSeats[SAMPLE_INDEX].howToSeat(),
                Converter.formatPrice(rowOfSeats[SAMPLE_INDEX].getPrice()));
    }

    public List<Room> getCinemaListByMovieTheaterId(int idMovieTheater) {
        return getMovieTheaterById(idMovieTheater).getRooms();
    }

    public List<Showtime> getShowtimeListByCinemaId(int idMovieTheater, int idCinema) {
        for (Room room : getCinemaListByMovieTheaterId(idMovieTheater)) {
            if (idCinema == room.getId()) {
                return room.getShowtimeList();
            }
        }
        return null;
    }

    public Room getCinemaById(int idCinema) {
        for (MovieTheater movieTheater : movieTheaterList) {
            for (Room room : movieTheater.getRooms()) {
                if (room.getId() == idCinema) {
                    return room;
                }
            }
        }
        return null;
    }
}
