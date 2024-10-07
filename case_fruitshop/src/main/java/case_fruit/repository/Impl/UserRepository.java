package case_fruit.repository.Impl;

import case_fruit.model.User;
import case_fruit.repository.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static case_fruit.repository.Impl.BaseRepository.getConnection;

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
                user.setUser_id(resultSet.getInt("user_id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getString("phone"));
                user.setRole_id(resultSet.getInt("role_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int save(User user) {
        if (!isValidRoleId(user.getRole_id())) {
            throw new IllegalArgumentException("role_id không hợp lệ: " + user.getRole_id());
        }

        String query = "INSERT INTO user (name, email, phone, role_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhoneNumber());
            statement.setInt(4, user.getRole_id());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void update(User user) {
        if (!isValidRoleId(user.getRole_id())) {
            throw new IllegalArgumentException("role_id không hợp lệ: " + user.getRole_id());
        }

        String query = "UPDATE user SET email = ?, phone = ? WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPhoneNumber());
            statement.setInt(3, user.getUser_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidRoleId(int roleId) {
        String sql = "SELECT COUNT(*) FROM user_role WHERE role_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, roleId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
