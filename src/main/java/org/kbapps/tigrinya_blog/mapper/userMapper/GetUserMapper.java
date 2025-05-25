package org.kbapps.tigrinya_blog.mapper.userMapper;

import org.kbapps.tigrinya_blog.dto.userDto.GetUserDto;
import org.kbapps.tigrinya_blog.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetUserMapper {
    GetUserDto toDto(User user);
    List<GetUserDto> toDtoList(List<User> users);
}
