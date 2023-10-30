package com.lrmd.agriculturestore.services;

import com.lrmd.agriculturestore.dtos.UserDto;
import com.lrmd.agriculturestore.entities.User;

import java.util.List;

public interface UserService  {

    // create

    UserDto createUser (UserDto userDto);

    // update

    UserDto updateUser(UserDto userDto, String userId);


    // delete

     void deleteUser(String userId);

    // get all users

    List<UserDto> getAllUser();


    //get single users by id

    UserDto getUser(String userId);


    // get single users by email

    UserDto getUserByEmail(String userId);

    // search user

    List<UserDto> searchUser(String keyword);

    // other user specific features











}
