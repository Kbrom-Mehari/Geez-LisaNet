package org.kbapps.tigrinya_blog.dto.userDto;

import lombok.Data;
import org.kbapps.tigrinya_blog.model.enums.Gender;

@Data
public class CreateUserDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
}
