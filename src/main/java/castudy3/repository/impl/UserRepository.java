package castudy3.repository.impl;

import castudy3.model.User;
import castudy3.repository.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static castudy3.dabatase.BaseRepository.getConnection;


public class UserRepository implements IUserRepository {

    private Connection connection;

    public UserRepository() {
        this.connection = getConnection();
        if (this.connection == null) {
            throw new IllegalStateException("Kết nối cơ sở dữ liệu không thành công!");
        }
    }

    @Override
    public User findById(int userId) {
        User user = null;
        String sql = "SELECT * FROM user WHERE user_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setRole_id(resultSet.getInt("role_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int save(User user) {
        String query = "INSERT INTO user (name, email, phone, role_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhone());
            statement.setInt(4, user.getRole_id());
            return statement.executeUpdate(); // Trả về số bản ghi đã thêm
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void update(User user) {
        String query = "UPDATE user SET email = ?, phone = ? WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPhone());
            statement.setInt(3, user.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
