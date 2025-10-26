package org.kbapps.geez_lisanet.utils.mapper.userMapper;

import org.kbapps.geez_lisanet.user.userDto.CreateUserDto;
import org.kbapps.geez_lisanet.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateUserMapper {
    User toEntity(CreateUserDto createUserDto);
}
