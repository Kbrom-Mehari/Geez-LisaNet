package org.kbapps.geez_lisanet.user.userDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.kbapps.geez_lisanet.user.enums.Gender;
import jakarta.validation.constraints.NotBlank;

@Data
public class CreateUserDto {
    @NotBlank(message="Username is required!")
    private String username;
    @Size(min =8,max=20, message = "Password must be between 8 and 20 characters!")
    @NotBlank(message = "Password is required!")
    private String password;
    @NotBlank(message = "First Name is required!")
    private String firstName;
    private String lastName;
    @Email(message="Invalid Email!")
    @NotBlank(message = "Email is required!")
    private String email;
    @NotNull(message = "Gender is required!")
    private Gender gender;
}
