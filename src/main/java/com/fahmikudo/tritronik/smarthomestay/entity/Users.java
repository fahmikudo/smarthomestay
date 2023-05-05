package com.fahmikudo.tritronik.smarthomestay.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseEntity {

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "email", length = 250)
    private String email;

    @Column(name = "password", length = 500)
    private String password;

    @Column(name = "fullname", length = 50)
    private String fullname;

    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

}
