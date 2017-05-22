package com.quickrental.restful.service.impl;

import com.quickrental.restful.model.Hire;
import com.quickrental.restful.repository.HireRepository;
import com.quickrental.restful.service.HireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 5/9/2017.
 */
@Service
public class HireServiceImpl implements HireService {
    @Autowired
    HireRepository hireRepository;

    @Override
    public List<Hire> getHireList() {
        return hireRepository.findAll();
    }

    @Override
    public Hire getHireById(Long id) {
        return hireRepository.findOne(id);
    }

    @Override
    public Hire addHire(Hire hire) {
        return hireRepository.save(hire);
    }

    @Override
    public Hire editHire(Hire hire) {
        return hireRepository.save(hire);
    }

    @Override
    public void deleteHire(Long id) {
        hireRepository.delete(id);
    }

	@Override
	public List<Hire> getRentListByUser(Long customerId) {
		List<Hire> rentListUser = hireRepository.findHiresByUser(customerId);
		return rentListUser;
	}
}
