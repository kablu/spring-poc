package com.spring.spring.locator;

public class CoVaxin implements IVaccination {

	
	public CoVaxin() {
		
	}

	@Override
	public void vaccinate(String name) {
		System.out.println("Opt For:" + name);
		
	}

	
}
