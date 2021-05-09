package com.spring.di.violation;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Kablu Mandal
 *
 */
public class WorldBeforeDI {

	public static void main(String[] args) {
		new ComputerProcessor()
			.addComputers(new Doubler())
			.addComputers(new Squarer())
			.computeAll(6);

	}

}

class ComputerProcessor {
	
	private List<Object> computers = new ArrayList<Object>();
	
	public ComputerProcessor addComputers(Object o) {
		computers.add(o);
		return ComputerProcessor.this;
	}
	
	public void computeAll(long value) {
		for(Object obj: computers) {
			
			long computedValue = -1;
			
			if(obj instanceof Doubler) {
				computedValue = ((Doubler) obj).computeDoubler(value);
			} else if(obj instanceof Squarer) {
				computedValue = ((Squarer) obj).computSquarer(value);
			}
			
			String name = obj.getClass().getSimpleName();
			
			System.out.println("Computer:" + name + " , value:" + value + "  Computed value:" + computedValue);
		}
	}
	
	
}

class Doubler {
	
	public long computeDoubler(long value) {
		return value*2;
	}
}

class Squarer {
	
	public long computSquarer(long value) {
		return value*value;
	}

	
}
