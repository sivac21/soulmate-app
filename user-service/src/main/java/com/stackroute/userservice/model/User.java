package com.stackroute.userservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Author Siva
 * @Date 10/30/2021 3:00 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = User.class)
@Entity
public class User implements Serializable {
    @Id
    private String email;
    private String password;
}
