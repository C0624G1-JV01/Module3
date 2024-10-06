package castudy3.model;

public class Account {
    private int id;
    private int userId; // Sử dụng userId
    private String username;
    private String password;

    public Account() {}
    public Account(int id, int userId, String username, String password) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
