package com.crud.app.service.impl;

import com.crud.app.dto.UserDTO;
import com.crud.app.entity.Users;
import com.crud.app.repo.UserRepo;
import com.crud.app.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;



    @Override
    public void createUser(UserDTO userDTO) {
        //save to db table
        Users dtoToUsers =  modelMapper.map(userDTO,Users.class);
        userRepo.save(dtoToUsers);

    }

    @Override
    public List<Users> getUserList() {
        return userRepo.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDTO getSingleUserById(Long id) {
        return modelMapper.map(userRepo.findById(id).get(),UserDTO.class);
    }


}
