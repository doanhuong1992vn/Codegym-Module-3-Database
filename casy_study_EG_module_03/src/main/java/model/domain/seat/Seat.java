package model.domain.seat;


import model.general_abstraction.ISurcharge;

public abstract class Seat implements ISurcharge {
    protected long id;
    protected String type;
    protected String code;
    protected boolean isEmpty;
    protected long idShowtime;
    protected int capacity;
    protected double price;

    public Seat(long id, String type, String code, boolean isEmpty, long idShowtime, int capacity, double price) {
        this.id = id;
        this.type = type;
        this.code = code;
        this.isEmpty = isEmpty;
        this.idShowtime = idShowtime;
        this.capacity = capacity;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public abstract double getSurcharge();
}
