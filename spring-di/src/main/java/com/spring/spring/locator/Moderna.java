package com.spring.spring.locator;

public class Moderna implements IVaccination {

	public Moderna() {
		
	}
	@Override
	public void vaccinate(String name) {
		System.out.println("Opt for:" + name);
		
	}

}
