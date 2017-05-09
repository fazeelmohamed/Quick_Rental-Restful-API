package com.quickrental.restful.service;

import com.quickrental.restful.model.Hire;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 5/9/2017.
 */
public interface HireService {

    List<Hire> getHireList();
    Hire getHireById(Long id);
    Hire addHire(Hire hire);
    Hire editHire(Hire hire);
    void deleteHire(Long id);
}
