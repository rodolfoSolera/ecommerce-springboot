package com.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

 Optional<User> findByEmail(String email);

}
