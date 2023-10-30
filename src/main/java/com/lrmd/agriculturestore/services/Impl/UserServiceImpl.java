package com.lrmd.agriculturestore.services.Impl;

import com.lrmd.agriculturestore.dtos.UserDto;
import com.lrmd.agriculturestore.entities.User;
import com.lrmd.agriculturestore.repositories.UserRepository;
import com.lrmd.agriculturestore.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.modelMapper.map(userDto, User.class);
        User createUser = this.userRepository.save(user);

        return  this.modelMapper.map(createUser,UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {

        User user = this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found user Id"));
        user.setName(userDto.getName());
        user.setAbout(userDto.getAbout());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        UserDto updatedUser = this.modelMapper.map(user, UserDto.class);

        return updatedUser;
    }

    @Override
    public void deleteUser(String userId) {

        User user = this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found given id"));

        this.userRepository.delete(user);
    }

    @Override
    public List<UserDto> getAllUser() {

        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());

        return userDtos;
    }

    @Override
    public UserDto getUser(String userId) {

        User user = this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Response Not found on server!!"));

        UserDto map = this.modelMapper.map(user, UserDto.class);

        return map;
    }

    @Override
    public UserDto getUserByEmail(String userId) {

        UserDto user = this.userRepository.findByEmail(userId).orElseThrow(() -> new RuntimeException("User not found email id "));

        UserDto map = this.modelMapper.map(user, UserDto.class);

        return map;
    }

    @Override
    public List<UserDto> searchUser(String keyword) {

        List<User> users = this.userRepository.findByNameContaining(keyword);

        List<UserDto> searchUser = users.stream().map(user -> this.modelMapper.map(users, UserDto.class)).collect(Collectors.toList());


        return searchUser ;
    }
}
