package oopd_assignment2;
import java.util.Random;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main_Class {
	
	static Date date = new Date();
	static String currentDate= new SimpleDateFormat("dd-MM-yyyy").format(date);
	

	public static void main(String[] args) {
		
		ArrayList<Vehicle_Two_wheeler> l1 = new ArrayList<Vehicle_Two_wheeler>();
		ArrayList<Vehicle_Type> l2 = new ArrayList<Vehicle_Type>();
		for(int i=0;i<5;i++) {
			l1.add(new Vehicle_Two_wheeler());
		}
		for(int i=0;i<5;i++) {
			l2.add(new Vehicle_Type());
		}
		
		System.out.printf("Reg.No.\tReg Valid Date\tNumber Of People\tFuel Type\tEmission Level\tOutstanding Fine\n");
		for(Vehicle_Two_wheeler obj:l1) {
			System.out.printf("%d\t%s\t\t%d\t\t%s\t\t\t%d\t\t%d\n",obj.getReg_no(),obj.getReg_valid_date(),obj.getNo_of_people(),obj.getFuel_type(),obj.getEmission_level(),obj.getOutstanding_fine());
			PUCcheck_two(obj);
			RTOcheck_two(obj);
		}
		
		System.out.printf("Reg.No.\tReg Valid Date\tNumber Of People\tFuel Type\tEmission Level\tOutstanding Fine\tVehicle Type\t\tPermit No.\tPermit Valid Date\tPaid Passenger Capacity\n");
		for(Vehicle_Type obj1:l2) {
			System.out.printf("%d\t%s\t\t%d\t\t%s\t\t\t%d\t\t%d\t\t%s\t%d\t\t%s\t\t\t%d\n",obj1.getReg_no(),obj1.getReg_valid_date(),obj1.getNo_of_people(),obj1.getFuel_type(),obj1.getEmission_level(),obj1.getOutstanding_fine(),obj1.getVehicleType(),obj1.getPermit_no(),obj1.getPermit_valid_date(),obj1.getPaid_passenger_capacity());
			PUCcheck_four(obj1);
			RTOcheck_four(obj1);
		}
		
		System.out.printf("Reg.No.\tReg Valid Date\tNumber Of People\tFuel Type\tEmission Level\tOutstanding Fine\n");
		for(Vehicle_Two_wheeler obj:l1) {
			System.out.printf("%d\t%s\t\t%d\t\t%s\t\t\t%d\t\t%d\n",obj.getReg_no(),obj.getReg_valid_date(),obj.getNo_of_people(),obj.getFuel_type(),obj.getEmission_level(),obj.getOutstanding_fine());
		}
		
		System.out.printf("Reg.No.\tReg Valid Date\tNumber Of People\tFuel Type\tEmission Level\tOutstanding Fine\tVehicle Type\t\tPermit No.\tPermit Valid Date\tPaid Passenger Capacity\n");
		for(Vehicle_Type obj1:l2) {
			System.out.printf("%d\t%s\t\t%d\t\t%s\t\t\t%d\t\t%d\t\t%s\t%d\t\t%s\t\t\t%d\n",obj1.getReg_no(),obj1.getReg_valid_date(),obj1.getNo_of_people(),obj1.getFuel_type(),obj1.getEmission_level(),obj1.getOutstanding_fine(),obj1.getVehicleType(),obj1.getPermit_no(),obj1.getPermit_valid_date(),obj1.getPaid_passenger_capacity());
		}

	}
	public static void PUCcheck_two(Vehicle_Two_wheeler obj) {
		Random rand = new Random();
		int n = 1+rand.nextInt(10);
		obj.setEmission_level(n);
	}
	
	public static void PUCcheck_four(Vehicle_Four_wheeler obj1) {
		Random rand = new Random();
		int n = 1+rand.nextInt(10);
		obj1.setEmission_level(n);
	}
	
	public static void RTOcheck_two(Vehicle_Two_wheeler obj) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date date1 = sdf.parse(obj.getReg_valid_date());
			Date date2 = sdf.parse(currentDate);
			if(date1.before(date2)) {
				obj.setOutstanding_fine(obj.getOutstanding_fine()+2000);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(obj.getEmission_level()>7) {
			obj.setOutstanding_fine(obj.getOutstanding_fine()+500);
		}		
	}
	
	public static void RTOcheck_four(Vehicle_Type obj1) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date date1 = sdf.parse(obj1.getReg_valid_date());
			Date date2 = sdf.parse(currentDate);
			if(date1.before(date2)) {
				obj1.setOutstanding_fine(obj1.getOutstanding_fine()+2000);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(obj1.getEmission_level()>7) {
			obj1.setOutstanding_fine(obj1.getOutstanding_fine()+500);
		}
		if(obj1.getVehicleType().equals("Passenger Vehicle")) {
			try {
				Date date1 = sdf.parse(obj1.getPermit_valid_date());
				Date date2 = sdf.parse(currentDate);
				if(date1.before(date2)) {
					obj1.setOutstanding_fine(obj1.getOutstanding_fine()+3000);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
