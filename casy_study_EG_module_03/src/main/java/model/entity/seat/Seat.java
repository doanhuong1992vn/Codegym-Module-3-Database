package model.entity.seat;


import model.general_abstraction.ISurcharge;

public abstract class Seat implements ISurcharge {
    private long id;
    private String type;
    private String code;
    private boolean isEmpty = true;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public long getIdShowtime() {
        return idShowtime;
    }

    public void setIdShowtime(long idShowtime) {
        this.idShowtime = idShowtime;
    }

    private long idShowtime;

    public Seat(String type, String code, boolean isEmpty, long idShowtime) {
        this.type = type;
        this.code = code;
        this.isEmpty = isEmpty;
        this.idShowtime = idShowtime;
    }

    public Seat(long id, String type, String code, boolean isEmpty, long idShowtime) {
        this.id = id;
        this.type = type;
        this.code = code;
        this.isEmpty = isEmpty;
        this.idShowtime = idShowtime;
    }

    @Override
    public abstract double getSurcharge();
}
