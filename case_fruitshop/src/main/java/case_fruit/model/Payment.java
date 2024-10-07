package case_fruit.model;

import java.util.Date;

public class Payment {
    private int id;
    private Date date;
    private String method_payment;
    private int shopping_cart_id;
    private int user_id;
    private double total_price;
    private  String transaction_id;
    public Payment() {}
    public Payment(int id,Date date,String method_payment,int shopping_cart_id,int user_id,double total_price,String transaction_id) {
        this.id = id;
        this.date = date;
        this.method_payment = method_payment;
        this.shopping_cart_id = shopping_cart_id;
        this.user_id = user_id;
        this.total_price = total_price;
        this.transaction_id = transaction_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMethod_payment() {
        return method_payment;
    }

    public void setMethod_payment(String method_payment) {
        this.method_payment = method_payment;
    }

    public int getShopping_cart_id() {
        return shopping_cart_id;
    }

    public void setShopping_cart_id(int shopping_cart_id) {
        this.shopping_cart_id = shopping_cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }
}