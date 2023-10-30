package com.lrmd.agriculturestore.repositories;

import com.lrmd.agriculturestore.dtos.UserDto;
import com.lrmd.agriculturestore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User, String>  {


     Optional<UserDto> findByEmail(String email);


     List<User> findByNameContaining(String keywords);






}
