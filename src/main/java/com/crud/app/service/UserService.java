package com.crud.app.service;

import com.crud.app.dto.UserDTO;
import com.crud.app.entity.Users;

import java.util.List;

public interface UserService {
    void createUser(UserDTO userDTO);
    List<Users> getUserList();
    void delete(Long id);
}
