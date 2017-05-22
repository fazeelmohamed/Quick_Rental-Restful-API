package com.quickrental.restful.service.impl;

import com.quickrental.restful.model.Rent;
import com.quickrental.restful.repository.RentRepository;
import com.quickrental.restful.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 5/9/2017.
 */

@Service
public class RentServiceImpl implements RentService {
    @Autowired
    RentRepository rentRepository;

    @Override
    public List<Rent> getRentList() {
        return rentRepository.findAll();
    }

    @Override
    public Rent getRentById(Long id) {
        return rentRepository.findOne(id);
    }

    @Override
    public Rent addRent(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public Rent editRent(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public void deleteRent(Long id) {
        rentRepository.delete(id);
    }

	@Override
	public List<Rent> getRentListByUser(Long customerId) {
		List<Rent> rentListUser = rentRepository.findRentsByUser(customerId);
		return rentListUser;
	}
}
