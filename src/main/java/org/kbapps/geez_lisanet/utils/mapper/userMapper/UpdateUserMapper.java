package org.kbapps.geez_lisanet.utils.mapper.userMapper;

import org.kbapps.geez_lisanet.user.userDto.UpdateUserDto;
import org.kbapps.geez_lisanet.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateUserMapper {
   User toEntity(UpdateUserDto updateUserDto);
}
