package org.kbapps.tigrinya_blog.dto.userDto;

import lombok.Data;
import org.kbapps.tigrinya_blog.model.enums.Gender;
import org.kbapps.tigrinya_blog.model.enums.Role;

@Data
public class GetUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String username;
    private Role role;
}
