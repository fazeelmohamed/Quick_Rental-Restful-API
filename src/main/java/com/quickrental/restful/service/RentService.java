package com.quickrental.restful.service;

import com.quickrental.restful.model.Rent;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 5/9/2017.
 */
public interface RentService {

    List<Rent> getRentList();
    Rent getRentById(Long id);
    Rent addRent(Rent rent);
    Rent editRent(Rent rent);
    void deleteRent(Long id);
}
