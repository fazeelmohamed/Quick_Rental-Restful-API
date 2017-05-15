package com.quickrental.restful.repository;

import com.quickrental.restful.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by MF Fazeel Mohamed on 5/7/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    /*@Query("select count(u) 0 from user u where u.username = :username")
    boolean existsIfUsername(@Param("username") String username);*/
}
