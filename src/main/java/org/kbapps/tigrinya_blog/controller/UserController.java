package org.kbapps.tigrinya_blog.controller;

import lombok.RequiredArgsConstructor;
import org.kbapps.tigrinya_blog.dto.userDto.CreateUserDto;
import org.kbapps.tigrinya_blog.dto.userDto.GetUserDto;
import org.kbapps.tigrinya_blog.dto.userDto.UpdateUserDto;
import org.kbapps.tigrinya_blog.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public List<GetUserDto> getUsers() {        // Using DTO
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public GetUserDto getUserById(@PathVariable Long id){    // Using DTO
        return userService.getUser(id);
    }
    @PostMapping
    public GetUserDto createUser(@RequestBody CreateUserDto createUserDto) {        // using DTO
        return userService.createUser(createUserDto);
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {      // DTO not needed here
        userService.deleteUser(id);
        return "User deleted";
    }
    @PatchMapping("/{id}")
    public GetUserDto updateUser(@PathVariable Long id, @RequestBody UpdateUserDto updateUserDto) {
       return userService.updateUser(updateUserDto,id);
    }
}
