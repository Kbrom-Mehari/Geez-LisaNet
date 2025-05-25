package org.kbapps.tigrinya_blog.mapper.userMapper;

import org.kbapps.tigrinya_blog.dto.userDto.UpdateUserDto;
import org.kbapps.tigrinya_blog.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateUserMapper {
   User toEntity(UpdateUserDto updateUserDto);
}
