package com.lrmd.agriculturestore.controllers;

import com.lrmd.agriculturestore.dtos.UserDto;
import com.lrmd.agriculturestore.entities.User;
import com.lrmd.agriculturestore.helper.ApiResponseMessage;
import com.lrmd.agriculturestore.services.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private  UserService userService;



    // create

    @PostMapping("/")
    public  ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){

        UserDto user = userService.createUser(userDto);

        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }


    // update

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable("userId") String userId,
             @Valid @RequestBody UserDto userDto){

        UserDto updateUser = userService.updateUser(userDto,userId);

       return  new ResponseEntity<>(updateUser,HttpStatus.OK);
    }



    // delete

    @DeleteMapping("/{userId}")
   public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable String userId) throws IOException{

          userService.deleteUser(userId);

          ApiResponseMessage message=ApiResponseMessage.builder().message("User deleted successfully !!").success(true).status(HttpStatus.OK).build();

          return  new ResponseEntity<>(message,HttpStatus.OK);


    }


    // get all






    // get single
















}
