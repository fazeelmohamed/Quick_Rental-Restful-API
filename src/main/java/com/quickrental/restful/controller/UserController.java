package com.quickrental.restful.controller;

import com.quickrental.restful.model.User;
import com.quickrental.restful.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by MF Fazeel Mohamed on 5/15/2017.
 */
@CrossOrigin(allowedHeaders="*",allowCredentials="true")
@RestController
@RequestMapping("/user")
public class UserController {

    final static Logger logger = Logger.getLogger(User.class);

    @Autowired
    UserService userService;

    //get user by username
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
        User user = userService.findByUsername(username);
        if(user == null){
            logger.debug("User with id " + username + " does not exists");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        logger.debug("Found User: " + user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }


    //get user by id
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserUsingId(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        if(user == null){
            logger.debug("User with id " + id + " does not exists");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        logger.debug("Found User: " + user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }


}
