package com.quickrental.restful.controller;


import com.quickrental.restful.model.Rent;
import com.quickrental.restful.service.RentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 5/9/2017.
 */

@RestController
@RequestMapping("/rent")
public class RentController {

    final static Logger logger = Logger.getLogger(Rent.class);

    @Autowired
    RentService rentService;

    //get rent
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Rent> getRentDetails(@PathVariable("id") Long id){
        Rent rent = rentService.getRentById(id);
        if(rent == null){
            logger.debug("Rent with id " + id + " does not exists");
            return new ResponseEntity<Rent>(HttpStatus.NOT_FOUND);
        }
        logger.debug("Found rent: " + rent);
        return new ResponseEntity<Rent>(rent,HttpStatus.OK);
    }

    //get rent list
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Rent>> getAllrentDetails() {
        List<Rent> rentList = rentService.getRentList();
        if (rentList.isEmpty()) {
            logger.debug("rents does not exists");
            return new ResponseEntity<List<Rent>>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + rentList.size() + " rents");
        logger.debug(Arrays.toString(rentList.toArray()));
        return new ResponseEntity<List<Rent>>(rentList, HttpStatus.OK);
    }

    //add rent
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Rent> addrent(@RequestBody Rent rent){
        Rent persistrent = rentService.addRent(rent);
        logger.debug("Added: " + persistrent);
        return new ResponseEntity<Rent>(persistrent,HttpStatus.CREATED);
    }

    //edit rent
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public ResponseEntity<Void> editrent(@RequestBody Rent rent) {
        Rent existingrent = rentService.getRentById(rent.getId());
        if (existingrent == null) {
            logger.debug("Rent with id " + rent.getId() + " does not exists");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            rentService.editRent(rent);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    //delete rent
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleterent(@PathVariable("id") Long id) {
        Rent existingrent = rentService.getRentById(id);
        if (existingrent == null) {
            logger.debug("Rent with id " + id + " does not exists");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            rentService.deleteRent(id);
            logger.debug("Rent with id " + id + " deleted");
            return new ResponseEntity<Void>(HttpStatus.GONE);
        }
    }
    
}
