package case_fruit.repository.Impl;

import case_fruit.model.Account;
import case_fruit.repository.IAccountRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static case_fruit.repository.Impl.BaseRepository.getConnection;


public class AccountRepository implements IAccountRepository {
    private Connection connection;

    public AccountRepository() {
        this.connection = getConnection();
        if (this.connection == null) {
            throw new IllegalStateException("Kết nối cơ sở dữ liệu không thành công!");
        }
    }

    @Override
    public Account findByUsername(String username) {
        Account account = null;
        String query = "SELECT * FROM account WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                account = new Account(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void save(Account newAccount) {
        String query = "INSERT INTO account (user_id, username, password) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, newAccount.getId());
            statement.setString(2, newAccount.getusername());
            statement.setString(3, newAccount.getsetPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Account currentAccount) {
        String query = "UPDATE account SET username = ?, password = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, currentAccount.getusername());
            statement.setString(2, currentAccount.getsetPassword());
            statement.setInt(3, currentAccount.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
