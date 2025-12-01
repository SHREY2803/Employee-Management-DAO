package model;

public class Admin extends Employee {
	private double allowance;

	public Admin(int id, String name, double salary, double allowance) {
		super(id, name, salary);
		this.allowance = allowance;
	}

	
	public double getAllowance() {
		return allowance;
	}


	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}


	public double calculateSalary() {
		return super.getSalary() + this.allowance;
	}
	
	public String toString() {
		return "Admin [" + super.toString() + ", allowance=" + allowance + "]";
	}

}