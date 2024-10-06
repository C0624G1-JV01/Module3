package castudy3.model;
import java.util.Date;

public class Orders {
    private int order_id;
    private int user_id;
    private int shopping_cart_id;
    private double total_price;
    private Date order_date;
    private String order_status;


    public Orders() {}


    public Orders(int order_id,int user_id,int shopping_cart_id,double total_price,Date order_date,String order_status) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.shopping_cart_id = shopping_cart_id;
        this.total_price = total_price;
        this.order_date = order_date;
        this.order_status = order_status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getShopping_cart_id() {
        return shopping_cart_id;
    }

    public void setShopping_cart_id(int shopping_cart_id) {
        this.shopping_cart_id = shopping_cart_id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }
}
