package org.kbapps.tigrinya_blog.dto.userDto;

import lombok.Data;
import org.kbapps.tigrinya_blog.model.enums.Gender;

@Data
public class UpdateUserDto {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String username;
    private String password;
}
