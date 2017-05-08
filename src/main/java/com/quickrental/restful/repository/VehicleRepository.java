package com.quickrental.restful.repository;

import com.quickrental.restful.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MF Fazeel Mohamed on 5/8/2017.
 */

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

}
