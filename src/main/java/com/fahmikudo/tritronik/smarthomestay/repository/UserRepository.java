package com.fahmikudo.tritronik.smarthomestay.repository;

import com.fahmikudo.tritronik.smarthomestay.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<Users> {

    Optional<Users> findByUsername(String username);

}
