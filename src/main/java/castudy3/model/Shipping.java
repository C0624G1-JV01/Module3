package castudy3.model;

import java.util.Date;

public class Shipping {
    private int id;
    private String address;
    private Date date;
    private double total_price;
    private int order_id;
    public Shipping(){}

    public Shipping(int id, String address, Date date, double total_price, int order_id) {
        this.id = id;
        this.address = address;
        this.date = date;
        this.total_price = total_price;
        this.order_id = order_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}