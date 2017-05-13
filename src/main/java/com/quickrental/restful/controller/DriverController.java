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
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
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
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
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
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<User> addDriver(@RequestBody User user){
        User persistUser = userService.addUser(user);
        logger.debug("Added: " + persistUser);
        return new ResponseEntity<User>(persistUser,HttpStatus.CREATED);
    }

    //edit driver
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public ResponseEntity<User> editDriver(@RequestBody User user) {
        User existingUser = userService.getUserById(user.getId());
        if (existingUser == null) {
            logger.debug("User with id " + user.getId() + " does not exists");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        } else {
            User persistDriver = userService.editUser(user);
            return new ResponseEntity<User>(persistDriver,HttpStatus.OK);
        }
    }

    //delete driver
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDriver(@PathVariable("id") Long id) {
        User existingUser = userService.getUserById(id);
        if (existingUser == null) {
            logger.debug("User with id " + id + " does not exists");
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        } else {
            userService.deleteUser(id);
            logger.debug("User with id " + id + " deleted");
            return new ResponseEntity<String>("Successfully deleted",HttpStatus.OK);
        }
    }
}
