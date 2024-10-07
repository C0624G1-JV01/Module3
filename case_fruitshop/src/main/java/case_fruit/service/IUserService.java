package case_fruit.service;

import case_fruit.model.User;

public interface IUserService {

    User getUserById(int userId);

    int addUser(User newUser);

    void updateUser(User currentUser);

    User getUserByEmail(String email);
}
