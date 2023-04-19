package model.entity;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
    private long id;
    private long idUser;
    private String userName;
    private long idMovieTheater;
    private String nameMovieTheater;
    private String addressMovieTheater;
    private long idRoom;
    private String nameRoom;
    private String nameMovie;
    private int movieDuration;
    private long idSeat;
    private String seatCode;
    private Date startTime;
    private Date endTime;
    private int numberOfPerson;
    private double price;
    private Date timeBooking;
    private boolean isPaid = false;
    private Date timePayment;
    private boolean isChecked = false;

    public Ticket(long id,
                  long idUser,
                  String userName,
                  long idMovieTheater,
                  String nameMovieTheater,
                  String addressMovieTheater,
                  long idRoom,
                  String nameRoom,
                  String nameMovie,
                  int movieDuration,
                  long idSeat,
                  String seatCode,
                  Date startTime,
                  Date endTime,
                  int numberOfPerson,
                  double price) {
        this.id = id;
        this.idUser = idUser;
        this.userName = userName;
        this.idMovieTheater = idMovieTheater;
        this.nameMovieTheater = nameMovieTheater;
        this.addressMovieTheater = addressMovieTheater;
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.nameMovie = nameMovie;
        this.movieDuration = movieDuration;
        this.idSeat = idSeat;
        this.seatCode = seatCode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numberOfPerson = numberOfPerson;
        this.price = price;
    }



    public String getTicketCode() {
        StringBuilder codeMovieTheater = Converter.convertNameToCode(getNameMovieTheater());
        StringBuilder codeCinema = Converter.convertNameToCode(getNameRoom());
        StringBuilder codeMovie = Converter.convertNameToCode(getNameMovie());
        return "EG" + getId() + "-" +
                codeMovieTheater + getIdMovieTheater() + "-" +
                codeCinema + getIdRoom() + "-" +
                getSeatCode() + "-" +
                codeMovie;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(long idSeat) {
        this.idSeat = idSeat;
    }

    public Date getTimeBooking() {
        return timeBooking;
    }

    public void setTimeBooking(Date timeBooking) {
        this.timeBooking = timeBooking;
    }

    public Date getTimePayment() {
        return timePayment;
    }

    public void setTimePayment(Date timePayment) {
        this.timePayment = timePayment;
    }

    public double getPrice() {
        return price;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setPaid(boolean paid) {
        this.isPaid = paid;
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }

    public static int getCount() {
        return count;
    }

    public long getId() {
        return id;
    }

    public long getIdMovieTheater() {
        return idMovieTheater;
    }

    public String getNameMovieTheater() {
        return nameMovieTheater;
    }

    public String getAddressMovieTheater() {
        return addressMovieTheater;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return String.format("Mã vé: %s. Giá: %s. Bán ngày: %s",
                getTicketCode(),
                Converter.formatPrice(getPrice()),
                new SimpleDateFormat("dd MMMM yyyy HH:mm:ss a").format(getTimePayment()));
    }
}
