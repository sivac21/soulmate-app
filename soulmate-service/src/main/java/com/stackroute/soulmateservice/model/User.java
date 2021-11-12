package com.stackroute.soulmateservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Author Siva
 * @Date 11/11/2021 3:05 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @NotNull
    private String email;

    @NotNull
//    @Pattern(regexp="^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$",message="password must 8 characters, 2 UpperCase, 1 Special Character, 2 Numbers & 3 LowerCase")
    private String password;
}
