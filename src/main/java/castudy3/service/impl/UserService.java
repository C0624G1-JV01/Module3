package castudy3.service.impl;

import castudy3.model.User;
import castudy3.repository.IUserRepository;
import castudy3.repository.impl.UserRepository;
import castudy3.service.IUserService;

public class UserService implements IUserService {
    private IUserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public int addUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public void updateUser(User currentUser) {
        userRepository.update(currentUser);
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }
}
