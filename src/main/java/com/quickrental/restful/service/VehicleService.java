package com.quickrental.restful.service;

import com.quickrental.restful.model.Vehicle;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 5/8/2017.
 */
public interface VehicleService {

    List<Vehicle> getVehiclesList();
    Vehicle getVehicleById(Long id);
    Vehicle addVehicle(Vehicle user);
    Vehicle editVehicle(Vehicle user);
    void deleteVehicle(Long id);

}
