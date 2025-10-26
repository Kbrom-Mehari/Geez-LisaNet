package org.kbapps.geez_lisanet.utils.mapper.userMapper;

import org.kbapps.geez_lisanet.user.userDto.GetUserDto;
import org.kbapps.geez_lisanet.user.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetUserMapper {
    GetUserDto toDto(User user);
    List<GetUserDto> toDtoList(List<User> users);
}
