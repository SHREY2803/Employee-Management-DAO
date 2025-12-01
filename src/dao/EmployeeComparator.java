package dao;

import java.util.Comparator;

import model.Employee;

public class EmployeeComparator implements Comparator<Employee> {
	OrderEnum order;
	String attribute;
	
	public EmployeeComparator(String attribute, OrderEnum order) {
		this.order = order;
		this.attribute = attribute.toLowerCase();
	}
	
	@Override
	public int compare(Employee o1, Employee o2) {
		
//		if(order.equals(order.ASC)) {
//			if(attribute.equals("salary")) {
//				return (int)(o1.getSalary() -o2.getSalary());
//			}
//			else if(attribute.equals("name")) {
//				return o1.getName().compareTo(o2.getName());
//			}
//			else {
//				return o1.getId()-o2.getId();
//				
//			}
//		}	
//		else {
//			if(attribute.equals("salary")) {
//				return (int)(o2.getSalary() -o1.getSalary());
//			}
//			else if(attribute.equals("name")) {
//				return o2.getName().compareTo(o1.getName());
//			}
//			else {
//				return o2.getId()-o1.getId();
//				
//			}
//		}
		int result = 0;

        switch (attribute) {
            case "salary":
                result = Double.compare(o1.getSalary(), o2.getSalary());
                break;

            case "name":
                result = o1.getName().compareToIgnoreCase(o2.getName());
                break;

            default:  // id
                result = o1.getId() - o2.getId();
        }

        // Reverse result if order is DESC
        if(order == OrderEnum.DSC) {
            return -result;
        }
        
        return result;
		
	}

}
