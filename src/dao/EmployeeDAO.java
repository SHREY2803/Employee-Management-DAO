package dao;
import java.util.ArrayList;
import java.util.Collections;

import model.*;

public class EmployeeDAO {
//	static Employee[] empArr;
	static ArrayList<Employee> employees = new ArrayList<Employee>();
//	static int empCount;
	
	static {
//		empArr = new Employee[20];
//		empCount = -1;
		
		employees.add(new HR(102,"Rohit",48000,4500));
		
		employees.add(new HR(101,"Ramesh",50000,5000));
		employees.add(new HR(103,"Raghav",45000,5200));
		
		employees.add(new SalesManager(201,"Rishab",45300,50,2000));
		employees.add(new SalesManager(202,"Reema",45390,52,2000));
		employees.add(new SalesManager(203,"Shrey",79360,55,2000));
		
		employees.add(new Admin(301,"Sakshi",35300,3000));
		employees.add(new Admin(302,"Seema",37320,3300));
		employees.add(new Admin(303,"Priya",44301,3520));
		
		
	}
	
	//Functions to be written here:
	/*
	 * 1.update
	 * 2.remove
	 * 3.search
	 * 4.sort*/
	
//	public boolean addEmployee(Employee e) {
//		if(empCount<empArr.length-1) {
//			empArr[++empCount] = e;
//			return true;
//		}
//		
//		return false;
		
//	}
	
	//Adding part
	public void addEmployee(Employee e) {
		employees.add(e);
	}
	
	public Employee searchEmployeeById(int id) {
		for(Employee e : employees) {
			if(e.getId() == id) {
				return e;
			}
		}
		return null; //not found employee with the given id
	}
	
	//Searching 
	public Employee searchByName(String name) {
		for(Employee e : employees) {
			if(e.getName().equalsIgnoreCase(name)) {
				return e;
			}
		}
		return null;
	}
	
	//Updating
	
	public boolean updateEmployeeSalary(int id, double newSalary) {
		for(Employee e : employees) {
			if(e.getId()==id) {
				e.setSalary(newSalary);
				return true;
			}
		}
		return false;
	}
	

	//Displaying All Employee
	public void displayAllEmployee() {
		
		for(Employee e : employees) {
			System.out.println(e);
			System.out.println();
		}
	}
	
	//Removing Employee
	public boolean removeEmployee(int id) {
	    for(int i=0;i<employees.size();i++) {
	    	if(employees.get(i).getId()==id) {
	    		employees.remove(i);
	    		return true;
	    	}

	    }
	    return false;
	}

	//Access and Display Salaries
	public Double getSalaryById(int id) {
	    for (Employee e : employees) {
	        if (e.getId() == id) {
	            return e.calculateSalary();
	        }
	    }
	    return null;
	}
	
	public Double getSalaryByName(String name) {
	    for (Employee e : employees) {
	        if (e.getName().equalsIgnoreCase(name)) {
	            return e.calculateSalary();
	        }
	    }
	    return null;
	}


	public void printSalaryReport() {
	    System.out.println("\n----- Salary Report -----");
	    for (Employee e : employees) {
	        System.out.println(e.getName() + " → Final Salary: " + e.calculateSalary());
	    }
	    System.out.println("-------------------------");
	}
	
	//Get total employees
	public static int getEmpCount() {
		return employees.size();
	}
	

//	public void sortBySalaryHighToLow() {
//        boolean swapped;
//        for (int i = 0; i < employees.size(); i++) {
//            swapped = false;
//            for (int j = 0; j < employees.size()-i-1; j++) {
//                if (employees.get(j).getSalary() < employees.get(j+1).getSalary()) {
//                    
//                    // Swap arr[j] and arr[j+1]
//                    Employee temp = employees.get(j);
//                    employees.set(j, employees.get(j+1));
//                    employees.set(j+1, temp);
//                    swapped = true;
//                }
//            }
//
//            // If no two elements were
//            // swapped by inner loop, then break
//            if (swapped == false)
//                break;
//        }
//	}

	public void sortEmployee(String attribute, OrderEnum order) {
		Collections.sort(employees, new EmployeeComparator(attribute,order));
	}
	
}

