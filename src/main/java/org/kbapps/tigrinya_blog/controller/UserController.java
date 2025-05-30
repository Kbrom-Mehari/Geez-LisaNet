package org.kbapps.tigrinya_blog.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.kbapps.tigrinya_blog.dto.userDto.CreateUserDto;
import org.kbapps.tigrinya_blog.dto.userDto.GetUserDto;
import org.kbapps.tigrinya_blog.dto.userDto.UpdateUserDto;
import org.kbapps.tigrinya_blog.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<GetUserDto>> getUsers() {        // Using DTO
         List<GetUserDto> users= userService.getAllUsers();
        return ResponseEntity.ok(users);         //returns status code: 200, ok
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetUserDto> getUserById(@PathVariable Long id){    // Using DTO
        GetUserDto user= userService.getUser(id);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
    @PostMapping
    public ResponseEntity<GetUserDto> createUser(@Valid @RequestBody CreateUserDto createUserDto) {        // using DTO
        GetUserDto user =userService.createUser(createUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);  //status code 201 created
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();

    }
    @PatchMapping("/{id}")
    public ResponseEntity<GetUserDto> updateUser(@PathVariable Long id, @RequestBody UpdateUserDto updateUserDto) {
       GetUserDto updatedUser= userService.updateUser(updateUserDto,id);
       if(updatedUser==null){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(updatedUser);
    }
}
