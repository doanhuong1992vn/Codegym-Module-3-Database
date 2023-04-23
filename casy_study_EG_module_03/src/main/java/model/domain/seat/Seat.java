package model.domain.seat;


import model.general_abstraction.ISurcharge;

public abstract class Seat implements ISurcharge {
    private long id;
    private String type;
    private String code;
    private boolean isEmpty = true;
    private long idShowtime;
    private int capacity;

    public Seat(long id, String type, String code, boolean isEmpty, long idShowtime, int capacity) {
        this.id = id;
        this.type = type;
        this.code = code;
        this.isEmpty = isEmpty;
        this.idShowtime = idShowtime;
        this.capacity = capacity;
    }

    public Seat(String type, String code, boolean isEmpty, long idShowtime, int capacity) {
        this.type = type;
        this.code = code;
        this.isEmpty = isEmpty;
        this.idShowtime = idShowtime;
        this.capacity = capacity;
    }

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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public abstract double getSurcharge();
}
