package org.kbapps.tigrinya_blog.controller;

import lombok.RequiredArgsConstructor;
import org.kbapps.tigrinya_blog.model.User;
import org.kbapps.tigrinya_blog.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public List<User> getUsers() {        // Using DTO
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){    // Using DTO
        return userService.getUser(id);
    }
    @PostMapping
    public User createUser(@RequestBody User  user) {        // using DTO
        return userService.createUser(user);
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {      // DTO not needed here
        userService.deleteUser(id);
        return "User deleted";
    }
    @PatchMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
       return userService.updateUser(user,id);
    }
}
