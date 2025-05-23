
package org.kbapps.tigrinya_blog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.kbapps.tigrinya_blog.model.enums.Gender;
import org.kbapps.tigrinya_blog.model.enums.Role;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
    private String gender;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
//    @Enumerated(EnumType.STRING)
//    private Role role;

}
