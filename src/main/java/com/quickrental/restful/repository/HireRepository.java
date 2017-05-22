package com.quickrental.restful.repository;

import com.quickrental.restful.model.Hire;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by MF Fazeel Mohamed on 5/9/2017.
 */
@Repository
public interface HireRepository extends JpaRepository<Hire,Long> {
	@Query(value = "select * from hire where customer_id = ?1", nativeQuery = true)
	List<Hire> findHiresByUser(Long customer_id);

}
