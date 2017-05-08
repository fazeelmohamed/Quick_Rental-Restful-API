package com.quickrental.restful.service;

import com.quickrental.restful.model.User;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 5/8/2017.
 */
public interface UserService {
    List<User> getUsersList();
    User getUserById(Long id);
    User addUser(User user);
    User editUser(User user);
    void deleteUser(Long id);
}
