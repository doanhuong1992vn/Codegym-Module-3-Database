package model.entity;

public class Product {
    private static long count = 0;
    private long id;
    private String name;
    private double price;
    private String description;
    private String producer;
    private boolean isDeleted = false;

    public Product(String name, double price, String description, String producer) {
        this.id = ++count;
        this.name = name;
        this.price = price;
        this.description = description;
        this.producer = producer;
    }

    public Product(long id, String name, double price, String description, String producer) {
        ++count;
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.producer = producer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return String.format("ID = %d; Name = %s; Price = %f; Description = %s; Producer = %s",
                id, name, price, description, producer);
    }
}
