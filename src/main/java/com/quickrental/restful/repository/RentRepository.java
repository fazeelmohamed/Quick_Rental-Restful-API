package com.quickrental.restful.repository;

import com.quickrental.restful.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MF Fazeel Mohamed on 5/9/2017.
 */

@Repository
public interface RentRepository extends JpaRepository<Rent,Long> {
}
