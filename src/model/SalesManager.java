package model;

public class SalesManager extends Employee {
	private int target;
	private double incentive;
	
	
	//Constructors
	public SalesManager() {
		super();
		this.target = 0;
		this.incentive = 0;
	}
	
	public SalesManager(int id, String name, double salary, int target, double incentive) {
		super(id, name, salary);
		this.target = target;
		this.incentive = incentive;
	}
	
	//setters and getters
	
	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public double getIncentive() {
		return incentive;
	}

	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}
	
	
	public double calculateSalary() {
		
		return super.getSalary() + (this.target * this.incentive);
	}
	
	public String toString() {
		return "SalesManager [" + super.toString() + ", target=" + target + ", incentive=" + incentive + "]";
	}
	
	
	
	
}

