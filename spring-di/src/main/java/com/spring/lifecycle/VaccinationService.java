package com.spring.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.spring.locator.IVaccination;
import com.spring.spring.locator.VaccinationFactory;

@Service
public class VaccinationService {

	@Autowired
	private VaccinationFactory vaccinationFactory;
	
	
	public void setVaccinationFactory(VaccinationFactory vaccinationFactory) {
		this.vaccinationFactory = vaccinationFactory;
	}


	public void makePayment(String name) {
		IVaccination iVaccination = vaccinationFactory.iVaccination(name);
		iVaccination.vaccinate("Moderna");
	}
}
