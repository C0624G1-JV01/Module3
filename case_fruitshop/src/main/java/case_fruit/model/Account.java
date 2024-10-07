package case_fruit.model;

public class Account {
    private int id;
    private int user_id;
    private String username;
    private String password;
    public Account(){}
    public Account (int id, int user_id, String username, String password) {
        this.id = id;
        this.user_id = user_id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getusername() {
        return username;
    }

    public void setUsername(String account_name) {
        this.username = account_name;
    }

    public String getsetPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}