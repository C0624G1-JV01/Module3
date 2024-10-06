package castudy3.service;


import castudy3.model.User;

public interface IUserService {

    User getUserById(int userId);

    int addUser(User newUser);

    void updateUser(User currentUser);

    User getUserByEmail(String email);
}
