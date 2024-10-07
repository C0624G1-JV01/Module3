package case_fruit.model;
import java.util.Date;

public class ShoppingCart {
    private int shopping_cart_id;
    private Double total_price ;
    private int user_id;
    private Date date;
    private String address;
    private String status;
    public ShoppingCart() {}
    public ShoppingCart(int shopping_cart_id, Double total_price, int user_id, Date ngay_mua, String address, String status){
        this.shopping_cart_id = shopping_cart_id;
        this.total_price = total_price;
        this.user_id = user_id;
        this.date = ngay_mua;
        this.address = address;
        this.status = status;
    }

    public int getShopping_cart_id() {
        return shopping_cart_id;
    }

    public void setShopping_cart_id(int shopping_cart_id) {
        this.shopping_cart_id = shopping_cart_id;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}