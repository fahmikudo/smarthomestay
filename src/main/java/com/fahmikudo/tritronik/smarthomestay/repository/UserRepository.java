package com.fahmikudo.tritronik.smarthomestay.repository;

import com.fahmikudo.tritronik.smarthomestay.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByUsername(String username);

}
