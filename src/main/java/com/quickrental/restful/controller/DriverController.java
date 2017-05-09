package com.quickrental.restful.controller;

import com.quickrental.restful.model.User;
import com.quickrental.restful.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 5/8/2017.
 */

@RestController
@RequestMapping("/driver")
public class DriverController {

    final static Logger logger = Logger.getLogger(User.class);

    @Autowired
    UserService userService;

    //get driver
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getDriver(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        if(user == null){
            logger.debug("User with id " + id + " does not exists");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        logger.debug("Found User: " + user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    //get drivers list
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllDrivers() {
        List<User> usersList = userService.getUsersList();
        if (usersList.isEmpty()) {
            logger.debug("Users does not exists");
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + usersList.size() + " Users");
        logger.debug(Arrays.toString(usersList.toArray()));
        return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);
    }

    //add driver
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<User> addDriver(@RequestBody User user){
        User persistUser = userService.addUser(user);
        logger.debug("Added: " + persistUser);
        return new ResponseEntity<User>(persistUser,HttpStatus.CREATED);
    }

    //edit driver
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public ResponseEntity<Void> editDriver(@RequestBody User user) {
        User existingUser = userService.getUserById(user.getId());
        if (existingUser == null) {
            logger.debug("User with id " + user.getId() + " does not exists");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            userService.editUser(user);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    //delete driver
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteDriver(@PathVariable("id") Long id) {
        User existingUser = userService.getUserById(id);
        if (existingUser == null) {
            logger.debug("User with id " + id + " does not exists");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            userService.deleteUser(id);
            logger.debug("User with id " + id + " deleted");
            return new ResponseEntity<Void>(HttpStatus.GONE);
        }
    }
}
