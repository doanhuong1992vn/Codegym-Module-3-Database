package model.domain;


import java.util.Date;

public class Showtime {
    private long id;
    private Date startTime;
    private Date endTime;
    private long idRoom;
    private long idMovie;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }
    public long getTimeOfStartTime() {
        return startTime.getTime();
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }

    public long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(long idMovie) {
        this.idMovie = idMovie;
    }

    public Showtime(Date startTime, Date endTime, long idRoom, long idMovie) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.idRoom = idRoom;
        this.idMovie = idMovie;
    }

    public Showtime(long id, Date startTime, Date endTime, long idRoom, long idMovie) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.idRoom = idRoom;
        this.idMovie = idMovie;
    }
}
