package com.quickrental.restful.controller;

import com.quickrental.restful.model.Hire;
import com.quickrental.restful.model.User;
import com.quickrental.restful.model.Vehicle;
import com.quickrental.restful.service.HireService;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.select;


/**
 * Created by MF Fazeel Mohamed on 5/9/2017.
 */
@CrossOrigin(allowedHeaders="*",allowCredentials="true")
@RestController
@RequestMapping("/hire")
public class HireController {
    final static Logger logger = Logger.getLogger(Hire.class);

    @Autowired
    HireService hireService;

    //get hire
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Hire> getHireDetails(@PathVariable("id") Long id){
        Hire hire = hireService.getHireById(id);
        if(hire == null){
            logger.debug("Hire with id " + id + " does not exists");
            return new ResponseEntity<Hire>(HttpStatus.NOT_FOUND);
        }
        logger.debug("Found Hire: " + hire);
        return new ResponseEntity<Hire>(hire,HttpStatus.OK);
    }

    //get hire list
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Hire>> getAllHireDetails() {
        List<Hire> hireList = hireService.getHireList();
        if (hireList.isEmpty()) {
            logger.debug("Hires does not exists");
            return new ResponseEntity<List<Hire>>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + hireList.size() + " Hires");
        logger.debug(Arrays.toString(hireList.toArray()));
        return new ResponseEntity<List<Hire>>(hireList, HttpStatus.OK);
    }

    //get pending hire list
    @RequestMapping(value = "/pending" , method = RequestMethod.GET)
    public ResponseEntity<List<Hire>> getPendingHireDetails() {
        List<Hire> hireList = hireService.getHireList();
        List<Hire> pendingHireList = select(hireList,having(on(Hire.class).getStatus(), Matchers.equalTo(1)));
        if (hireList.isEmpty()) {
            logger.debug("Hire does not exists");
            return new ResponseEntity<List<Hire>>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + pendingHireList.size() + " Hires");
        logger.debug(Arrays.toString(pendingHireList.toArray()));
        return new ResponseEntity<List<Hire>>(pendingHireList, HttpStatus.OK);
    }

    //add hire
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Hire> addHire(@RequestBody Hire hire){
    	System.out.println("Hire time: "+hire.getHireTime());
        Hire persistHire = hireService.addHire(hire);
        logger.debug("Added: " + persistHire);
        return new ResponseEntity<Hire>(persistHire,HttpStatus.CREATED);
    }

    //edit hire
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public ResponseEntity<Hire> editHire(@RequestBody Hire hire) {
        Hire existingHire = hireService.getHireById(hire.getId());
        if (existingHire == null) {
            logger.debug("Hire with id " + hire.getId() + " does not exists");
            return new ResponseEntity<Hire>(HttpStatus.NOT_FOUND);
        } else {
            Hire persistHire = hireService.editHire(hire);
            return new ResponseEntity<Hire>(persistHire,HttpStatus.OK);
        }
    }

    //delete hire
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteHire(@PathVariable("id") Long id) {
        Hire existingHire = hireService.getHireById(id);
        if (existingHire == null) {
            logger.debug("Hire with id " + id + " does not exists");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            hireService.deleteHire(id);
            logger.debug("Hire with id " + id + " deleted");
            return new ResponseEntity<Void>(HttpStatus.GONE);
        }
    }

}
