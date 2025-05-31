package org.kbapps.tigrinya_blog.service;

import lombok.RequiredArgsConstructor;
import org.kbapps.tigrinya_blog.dto.userDto.CreateUserDto;
import org.kbapps.tigrinya_blog.dto.userDto.GetUserDto;
import org.kbapps.tigrinya_blog.dto.userDto.UpdateUserDto;
import org.kbapps.tigrinya_blog.exception.DuplicateEntryException;
import org.kbapps.tigrinya_blog.exception.ResourceNotFoundException;
import org.kbapps.tigrinya_blog.mapper.userMapper.CreateUserMapper;
import org.kbapps.tigrinya_blog.mapper.userMapper.GetUserMapper;
import org.kbapps.tigrinya_blog.model.User;
import org.kbapps.tigrinya_blog.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CreateUserMapper createUserMapper;
    private final GetUserMapper getUserMapper;

    public GetUserDto createUser(CreateUserDto createUserDto) {
        if(userRepository.existsByEmail(createUserDto.getEmail())){
            throw new DuplicateEntryException("Email already exists");
        }
        if(userRepository.existsByUsername(createUserDto.getUsername())){
            throw new DuplicateEntryException("Username already exists");
        }
        User user=createUserMapper.toEntity(createUserDto);
        return getUserMapper.toDto(userRepository.save(user)) ;
    }

    public GetUserDto updateUser(UpdateUserDto updateUserDto, Long id) {
        User oldUser=userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with Id: "+id+" Not Found"));
           if(updateUserDto.getFirstName()!=null){
               oldUser.setFirstName(updateUserDto.getFirstName());
           }
           if(updateUserDto.getLastName()!=null){
               oldUser.setLastName(updateUserDto.getLastName());
           }
           if(updateUserDto.getPassword()!=null){
               oldUser.setPassword(updateUserDto.getPassword());
           }
           if(updateUserDto.getGender()!=null){
               oldUser.setGender(updateUserDto.getGender());
           }
           if(updateUserDto.getUsername()!=null){
               oldUser.setUsername(updateUserDto.getUsername());
           }
           userRepository.save(oldUser);
           return getUserMapper.toDto(oldUser);
    }

    public GetUserDto getUser(Long id) {    //for controller
        User user=userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with Id: "+id+" Not Found"));
        return getUserMapper.toDto(user);
    }
    public List<GetUserDto> getAllUsers() {
        return getUserMapper.toDtoList(userRepository.findAll());
    }
    public void deleteUser(Long id){    // DTO not needed for deleting
        userRepository.findById(id)
               .ifPresentOrElse(userRepository::
                       delete,()->{throw new ResourceNotFoundException("User with Id: "+id+" Not Found");});

    }

    public User findUserById(Long id) {      //only for Mappers
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with Id: "+id+" Not Found"));
    }
}
