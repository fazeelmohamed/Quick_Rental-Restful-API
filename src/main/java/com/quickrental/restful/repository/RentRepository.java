package com.quickrental.restful.repository;

import com.quickrental.restful.model.Rent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by MF Fazeel Mohamed on 5/9/2017.
 */

@Repository
public interface RentRepository extends JpaRepository<Rent,Long> {
	@Query(value = "select * from rent where customer_id = ?1", nativeQuery = true)
	List<Rent> findRentsByUser(Long customer_id);
}
