package org.kbapps.geez_lisanet.user.userDto;

import lombok.Data;
import org.kbapps.geez_lisanet.user.enums.Gender;
import org.kbapps.geez_lisanet.user.enums.Role;

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
