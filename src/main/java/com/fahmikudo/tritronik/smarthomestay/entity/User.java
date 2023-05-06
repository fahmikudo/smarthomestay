package com.fahmikudo.tritronik.smarthomestay.entity;

import com.fahmikudo.tritronik.smarthomestay.model.LoginAbleUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity implements LoginAbleUser {

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "email", length = 250)
    private String email;

    @Column(name = "password", length = 500)
    private String password;

    @Column(name = "full_name", length = 50)
    private String fullName;

    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

    // ================================= OVERRIDING USER DETAILS ===================================== //
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
