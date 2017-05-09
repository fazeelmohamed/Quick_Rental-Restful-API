package com.quickrental.restful.repository;

import com.quickrental.restful.model.Hire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MF Fazeel Mohamed on 5/9/2017.
 */
@Repository
public interface HireRepository extends JpaRepository<Hire,Long> {

}
