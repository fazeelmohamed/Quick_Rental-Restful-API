package com.quickrental.restful.controller;

import com.quickrental.restful.model.User;
import com.quickrental.restful.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by MF Fazeel Mohamed on 5/8/2017.
 */

@RestController
@RequestMapping("/driver")
public class DriverController {

    final static Logger logger = Logger.getLogger(User.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getDriver(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        if(user == null){
            logger.debug("User with id " + id + " does not exists");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        logger.debug("Found Employee:: " + user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<User> addDriver(@RequestBody User user){
        User persistUser = userService.addUser(user);
        logger.debug("Added:: " + persistUser);
        return new ResponseEntity<User>(persistUser,HttpStatus.CREATED);
    }
}
