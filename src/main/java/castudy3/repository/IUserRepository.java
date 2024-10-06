package castudy3.repository;


import castudy3.model.User;

public interface IUserRepository {

    User findById(int userId);

    int save(User newUser);

    void update(User currentUser);
}
