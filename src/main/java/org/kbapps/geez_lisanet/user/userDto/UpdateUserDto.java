package org.kbapps.geez_lisanet.user.userDto;

import lombok.Data;
import org.kbapps.geez_lisanet.user.enums.Gender;

@Data
public class UpdateUserDto {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String username;
    private String password;
}
