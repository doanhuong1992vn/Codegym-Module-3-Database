package model.entity.cinema;


import model.general_abstraction.ISurcharge;

public abstract class Cinema implements ISurcharge {
    private long id;
    private String type;
    private String name;
    private String address;

    protected Cinema(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Cinema(long id, String type, String name, String address) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public abstract double getSurcharge();
}
