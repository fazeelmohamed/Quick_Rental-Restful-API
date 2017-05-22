package com.quickrental.restful.service.impl;

import com.quickrental.restful.model.Vehicle;
import com.quickrental.restful.repository.VehicleRepository;
import com.quickrental.restful.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 5/8/2017.
 */

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getVehiclesList() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findOne(id);
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle editVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.delete(id);
    }

	
    @Override
	public List<Vehicle> getAvailableVehicles(Boolean bool) {
    	List<Vehicle> vehiclesList = vehicleRepository.findAllByAvailable(bool);
		return vehiclesList;
	}
	
	
}
