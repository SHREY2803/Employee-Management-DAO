package model;

public class HR extends Employee{
	double commission;
	

	//constructors
	public HR(int id, String name, double salary, double commission) {
		super(id, name, salary);
		this.commission = commission;
	}
	
	public HR() {
		super();
		this.commission = 0;
	}

	//setters and getters
	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	
	
	public double calculateSalary() {
		 
		return super.getSalary() + this.commission;
	}
	
	
	public String toString() {
		
		return "HR [" + super.toString() + ", commission=" + commission + "]";
	}
	
	
}
