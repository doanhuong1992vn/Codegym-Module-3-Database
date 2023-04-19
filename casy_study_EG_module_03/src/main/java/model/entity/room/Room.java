package model.entity.room;

import model.general_abstraction.ISurcharge;

public abstract class Room implements ISurcharge {
    protected long id;
    protected String type;
    protected String name;
    protected long idCinema;
    protected int columnSeat = 4;
    protected int rowSeat = 4;
    protected Room(long id, String type, String name, int rowSeat, int columnSeat, long idCinema) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.columnSeat = columnSeat;
        this.rowSeat = rowSeat;
        this.idCinema = idCinema;
    }

    protected Room(String type, String name, long idCinema, int columnSeat, int rowSeat) {
        this.type = type;
        this.name = name;
        this.idCinema = idCinema;
        this.columnSeat = columnSeat;
        this.rowSeat = rowSeat;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(long idCinema) {
        this.idCinema = idCinema;
    }

    public int getColumnSeat() {
        return columnSeat;
    }

    public void setColumnSeat(int columnSeat) {
        this.columnSeat = columnSeat;
    }

    public int getRowSeat() {
        return rowSeat;
    }

    public void setRowSeat(int rowSeat) {
        this.rowSeat = rowSeat;
    }
    @Override
    public abstract double getSurcharge();
}
