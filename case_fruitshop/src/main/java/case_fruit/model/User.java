package case_fruit.model;

import java.util.Date;

public class User {
    private int user_id;
    private String name;
    private String email;
    private String phone;
    private int role_id;
    public User(){}
    public User(int user_id,String name,Date user_date,Date date_of_birth,String email,String phone_number,int role_id){
        this.user_id=user_id;
        this.name= name;
        this.email=email;
        this.phone =phone_number;
        this.role_id=role_id;
    }

    public User(int i, String name, String email, String phone, int i1) {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phone;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone = phoneNumber;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}