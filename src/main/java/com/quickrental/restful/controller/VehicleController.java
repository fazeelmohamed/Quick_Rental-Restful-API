package com.quickrental.restful.controller;


import com.quickrental.restful.model.Vehicle;
import com.quickrental.restful.service.VehicleService;
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
@RequestMapping("/vehicle")
public class VehicleController {

    final static Logger logger = Logger.getLogger(Vehicle.class);

    @Autowired
    VehicleService vehicleService;

    //get vehicle
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") Long id){
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if(vehicle == null){
            logger.debug("Vehicle with id " + id + " does not exists");
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
        }
        logger.debug("Found Vehicle:: " + vehicle);
        return new ResponseEntity<Vehicle>(vehicle,HttpStatus.OK);
    }

    //get vehicles list
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehiclesList = vehicleService.getVehiclesList();
        if (vehiclesList.isEmpty()) {
            logger.debug("Vehicle does not exists");
            return new ResponseEntity<List<Vehicle>>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + vehiclesList.size() + " Vehicles");
        logger.debug(Arrays.toString(vehiclesList.toArray()));
        return new ResponseEntity<List<Vehicle>>(vehiclesList, HttpStatus.OK);
    }

    //add vehicle
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle){
        System.out.println("Vehicle: "+ vehicle);
        Vehicle persistVehicle = vehicleService.addVehicle(vehicle);
        logger.debug("Added:: " + persistVehicle);
        return new ResponseEntity<Vehicle>(persistVehicle,HttpStatus.CREATED);
    }

    //edit vehicle
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public ResponseEntity<Vehicle> editVehicle(@RequestBody Vehicle vehicle) {
        Vehicle existingVehicle = vehicleService.getVehicleById(vehicle.getId());
        if (existingVehicle == null) {
            logger.debug("Vehicle with id " + vehicle.getId() + " does not exists");
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
        } else {
            Vehicle persistVehicle = vehicleService.editVehicle(vehicle);
            return new ResponseEntity<Vehicle>(persistVehicle,HttpStatus.OK);
        }
    }

    //delete vehicle
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") Long id) {
        Vehicle existingVehicle = vehicleService.getVehicleById(id);
        if (existingVehicle == null) {
            logger.debug("Vehicle with id " + id + " does not exists");
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        } else {
            vehicleService.deleteVehicle(id);
            logger.debug("Vehicle with id " + id + " deleted");
            return new ResponseEntity<String>("Successfully deleted",HttpStatus.OK);
        }
    }
}
