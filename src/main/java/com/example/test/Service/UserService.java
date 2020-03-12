package com.example.test.Service;

import com.example.test.Model.User;
import com.example.test.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByName(String name) {
        Optional<User> optionalUser = userRepository.findByName(name);
        return optionalUser.orElseGet(() -> save(User.builder().name(name).build()));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(String name) {
        userRepository.deleteByName(name);
    }
}
