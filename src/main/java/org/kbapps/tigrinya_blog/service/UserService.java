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

    public User createUser(User  user) {
        userRepository.save(user);
        return user;
    }

    public User updateUser(User user, Long id) {
        User oldUser=userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with Id: "+id+" Not Found"));
           if(user.getFirstName()!=null){
               oldUser.setFirstName(user.getFirstName());
           }
           if(user.getLastName()!=null){
               oldUser.setLastName(user.getLastName());
           }
           if(user.getPassword()!=null){
               oldUser.setPassword(user.getPassword());
           }
           if(user.getGender()!=null){
               oldUser.setGender(user.getGender());
           }
           if(user.getUsername()!=null){
               oldUser.setUsername(user.getUsername());
           }
           userRepository.save(oldUser);
           return oldUser;
    }

    public User getUser(Long id) {
        User user=userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with Id: "+id+" Not Found"));
        return user;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();

    }
    public void deleteUser(Long id){
        userRepository.findById(id)
                .ifPresentOrElse(userRepository:: delete,()->{throw new ResourceNotFoundException("User with Id: "+id+" Not Found");});
    }
}
