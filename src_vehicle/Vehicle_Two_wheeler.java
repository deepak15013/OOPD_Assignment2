package oopd_assignment2;

import java.util.GregorianCalendar;
import java.util.Random;
import java.util.GregorianCalendar;

public class Vehicle_Two_wheeler extends Vehicle {
	
	Random rand = new Random();
	GregorianCalendar gc = new GregorianCalendar();	
	
	public Vehicle_Two_wheeler() {
		
		//----------setting registration number
		this.setReg_no(1+rand.nextInt(1000));			
		
		//----------setting registration valid date
		int year = randBetween(2010,2020);
		gc.set(gc.YEAR,year);
		int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
		gc.set(gc.DAY_OF_YEAR,dayOfYear);
		this.setReg_valid_date(gc.get(gc.DAY_OF_MONTH) + "-" + gc.get(gc.MONTH) + "-" + gc.get(gc.YEAR));
		
		//---------setting no of people
		int n=1+rand.nextInt(2);
		this.setNo_of_people(n);
		
		//--------setting fuel type
		int fuel = rand.nextInt(2);
		if(fuel == 0) {
			this.setFuel_type("Petrol");
		}
		else
			this.setFuel_type("Diesel");
		
		//--------setting emission level
		this.setEmission_level(0);
		
		//--------setting outstanding fine
		this.setOutstanding_fine(0);
	}
	
	public static int randBetween(int start, int end) {
		return start + (int)Math.round(Math.random() * (end - start));
	}
}
