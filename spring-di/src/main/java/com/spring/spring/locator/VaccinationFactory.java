package com.spring.spring.locator;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface VaccinationFactory {
	public IVaccination iVaccination(String name);
}
