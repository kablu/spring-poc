package com.spring.di.inversion;

import java.util.ArrayList;
import java.util.List;

public class IoCExample {

	public static void main(String[] args) {
		
		new ComputerProcessor()
			.addComputer(new Doubler())
			.addComputer(new Square())
			.computerAll(6);
	}
}

class ComputerProcessor {
	
	private List<Computer> computers = new ArrayList<>();
	
	public ComputerProcessor addComputer(Computer c) {
		computers.add(c);
		return ComputerProcessor.this;
	}
	
	public void computerAll(long value) {
		for(Computer s: computers) {
			String name = s.getClass().getSimpleName();
			System.out.println("Computer: " + name + "  ,value:" + value + "  Computed Value: " + s.compute(value) );
		}
	}
}

interface Computer {
	long compute(long value);
}

class Doubler implements Computer {
	@Override
	public long compute(long value) {
		return value*2;
	}
}

class Square implements Computer {
	@Override
	public long compute(long value) {
		return value*value;
	}
}
