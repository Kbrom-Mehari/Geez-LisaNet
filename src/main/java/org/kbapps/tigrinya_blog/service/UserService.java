package org.kbapps.tigrinya_blog.service;

import lombok.RequiredArgsConstructor;
import org.kbapps.tigrinya_blog.exception.ResourceNotFoundException;
import org.kbapps.tigrinya_blog.model.User;
import org.kbapps.tigrinya_blog.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(User user, Long id) {
        User oldUser=userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with Id: "+id+" Not Found"));
        oldUser.setPassword(user.getPassword());
        oldUser.setUsername(user.getUsername());
        return userRepository.save(oldUser);
    }
    public User getUser(Long id) {
        return  userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with Id: "+id+" Not Found"));
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public String deleteUser(Long id){
        userRepository.findById(id)
                .ifPresentOrElse(userRepository:: delete,()->{throw new ResourceNotFoundException("User with Id: "+id+" Not Found");});
        return "User with Id: "+id+" Deleted";
    }
}
