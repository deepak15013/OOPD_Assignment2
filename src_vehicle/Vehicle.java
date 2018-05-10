package oopd_assignment2;

public class Vehicle {
	private int reg_no;
	private String reg_valid_date;
	private int no_of_people;
	private String fuel_type;
	private int emission_level;
	private int outstanding_fine;
	

	public int getReg_no() {
		return reg_no;
	}
	public void setReg_no(int reg_no) {
		this.reg_no = reg_no;
	}
	
	public String getReg_valid_date() {
		return reg_valid_date;
	}
	public void setReg_valid_date(String reg_valid_date) {
		this.reg_valid_date = reg_valid_date;
	}
	
	public int getNo_of_people() {
		return no_of_people;
	}
	public void setNo_of_people(int no_of_people) {
		this.no_of_people = no_of_people;
	}
	
	
	public String getFuel_type() {
		return fuel_type;
	}
	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}
	
	public int getEmission_level() {
		return emission_level;
	}
	public void setEmission_level(int emission_level) {
		this.emission_level = emission_level;
	}
	
	public int getOutstanding_fine() {
		return outstanding_fine;
	}
	public void setOutstanding_fine(int outstanding_fine) {
		this.outstanding_fine = outstanding_fine;
	}	
}
