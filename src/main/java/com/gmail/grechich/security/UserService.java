package com.gmail.grechich.security;

import com.gmail.grechich.config.AppConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<CustomUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CustomUser findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Transactional
    public boolean addUser(String login, String passHash, UserRole role) {
        if (userRepository.existsByLogin(login))
            return false;
        CustomUser user = new CustomUser(login, passHash, role);
        userRepository.save(user);
        return true;
    }


    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
