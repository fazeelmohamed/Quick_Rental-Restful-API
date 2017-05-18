package com.quickrental.restful.controller;

import com.quickrental.restful.model.User;
import com.quickrental.restful.service.UserService;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.select;

import java.util.Arrays;
import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 5/8/2017.
 */
@CrossOrigin(allowedHeaders="*",allowCredentials="true")
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

    //get all drivers list
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllDrivers() {
        List<User> usersList = userService.getUsersList();
        List<User> driverList = select(usersList,having(on(User.class).getUserRole(), Matchers.equalTo(3)));

        if (driverList.isEmpty()) {
            logger.debug("Users does not exists");
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found available " + driverList.size() + " Drivers");
        logger.debug(Arrays.toString(driverList.toArray()));
        return new ResponseEntity<List<User>>(driverList, HttpStatus.OK);
    }

    //get available drivers list
    @RequestMapping(value = "/available",method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAvailableDrivers() {
        List<User> usersList = userService.getUsersList();

        List<User> driverList = select(usersList,having(on(User.class).getUserRole(), Matchers.equalTo(3)));

        List<User> availableDriverList = select(driverList,having(on(User.class).isAvailable(), Matchers.equalTo(true)));
        if (driverList.isEmpty()) {
            logger.debug("Users does not exists");
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found available " + availableDriverList.size() + " Drivers");
        logger.debug(Arrays.toString(availableDriverList.toArray()));
        return new ResponseEntity<List<User>>(availableDriverList, HttpStatus.OK);
    }

    //get unavailable drivers list
    @RequestMapping(value = "/unavailable",method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUnAvailableDrivers() {
        List<User> usersList = userService.getUsersList();
        List<User> driverList = select(usersList,having(on(User.class).getUserRole(), Matchers.equalTo(3)));
        List<User> availableDriverList = select(driverList,having(on(User.class).isAvailable(), Matchers.equalTo(false)));
        if (driverList.isEmpty()) {
            logger.debug("Users does not exists");
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found available " + availableDriverList.size() + " Drivers");
        logger.debug(Arrays.toString(availableDriverList.toArray()));
        return new ResponseEntity<List<User>>(availableDriverList, HttpStatus.OK);
    }

    //add driver
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<User> addDriver(@RequestBody User user){
        user.setUserRole(3);
        User persistUser = userService.addUser(user);
        logger.debug("Added: " + persistUser);
        return new ResponseEntity<User>(persistUser,HttpStatus.CREATED);
    }

    //edit driver
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public ResponseEntity<User> editDriver(@RequestBody User user) {
        user.setUserRole(3);
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
