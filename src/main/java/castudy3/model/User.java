package castudy3.model;

public class User {
    private int userId;
    private String name;
    private String email;
    private String phone;
    private int role_id;

    public User (){}

    public User(int userId, String name, String email, String phone, int role_id) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role_id = role_id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }


}
