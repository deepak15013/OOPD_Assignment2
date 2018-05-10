package oopd_assignment2;
import java.util.Random;

public class Vehicle_Type extends Vehicle_Four_wheeler{
	Random rand = new Random();
	private String VehicleType;
	private int permit_no;
	private String permit_valid_date;
	private int paid_passenger_capacity;
	
	
	
	public Vehicle_Type() {
		int n = rand.nextInt(2);
		if(n==0) {
			setVehicleType("Passenger Vehicle");
			AssignPermit();
		}
		else {
			setVehicleType("Commercial Vehicle");
			setPermit_no(0);
			setPermit_valid_date("N/A\t");
			setPaid_passenger_capacity(0);
		}
			
	}
	public void AssignPermit() {
		
		int n = 5000+rand.nextInt(1000);
		setPermit_no(n);
		
		int y = randBetween(2010,2020);
		gc.set(gc.YEAR,y);
		int dayOfY = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
		gc.set(gc.DAY_OF_YEAR,dayOfY);
		this.setPermit_valid_date(gc.get(gc.DAY_OF_MONTH) + "-" + gc.get(gc.MONTH) + "-" + gc.get(gc.YEAR));
		
		int x = 1+rand.nextInt(80);
		setPaid_passenger_capacity(x);
	}
	
	
	public int getPaid_passenger_capacity() {
		return paid_passenger_capacity;
	}
	public void setPaid_passenger_capacity(int paid_passenger_capacity) {
		this.paid_passenger_capacity = paid_passenger_capacity;
	}
	
	public String getVehicleType() {
		return VehicleType;
	}
	public void setVehicleType(String vehicleType) {
		VehicleType = vehicleType;
	}
	public int getPermit_no() {
		return permit_no;
	}
	public void setPermit_no(int permit_no) {
		this.permit_no = permit_no;
	}
	public String getPermit_valid_date() {
		return permit_valid_date;
	}
	public void setPermit_valid_date(String permit_valid_date) {
		this.permit_valid_date = permit_valid_date;
	}
	
	
}
