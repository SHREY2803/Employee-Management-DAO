package view;

import java.util.Scanner;

import dao.EmployeeDAO;
import dao.OrderEnum;
import model.Admin;
import model.Employee;
import model.HR;
import model.SalesManager;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();
        int choice;

        do {
            System.out.println("\n===== Employee Management Menu =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Remove Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Get Salary by ID");
            System.out.println("7. Get Salary by Name");
            System.out.println("8. Get Salary of All Employees");
            System.out.println("9. Get Total Number of Employees");
            System.out.println("10. Sort Employees"); 
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                System.out.println("Enter Employee Type (1-HR, 2-Admin, 3-SalesManager): ");
                int type = sc.nextInt();

                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Base Salary: ");
                double salary = sc.nextDouble();

                if (type == 1) {
                    System.out.print("Enter Commission: ");
                    double comm = sc.nextDouble();
                    dao.addEmployee(new HR(id, name, salary, comm));
                    System.out.println("HR added successfully!");
                } 
                else if (type == 2) {
                    System.out.print("Enter Allowance: ");
                    double allowance = sc.nextDouble();
                    dao.addEmployee(new Admin(id, name, salary, allowance));
                    System.out.println("Admin added successfully!");
                } 
                else if (type == 3) {
                    System.out.print("Enter Target: ");
                    int target = sc.nextInt();
                    System.out.print("Enter Incentive per Target: ");
                    double incentive = sc.nextDouble();
                    dao.addEmployee(new SalesManager(id, name, salary, target, incentive));
                    System.out.println("Sales Manager added successfully!");
                } 
                else {
                    System.out.println("Invalid Employee Type!");
                }
                break;

            case 2:
            	System.out.println("\nSearch By:");
                System.out.println("1. Search by ID");
                System.out.println("2. Search by Name");
                System.out.print("Enter choice: ");
                int sChoice = sc.nextInt();
                sc.nextLine(); // consume newline

                if (sChoice == 1) {
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    Employee emp1 = dao.searchEmployeeById(sid);

                    if (emp1 != null)
                        System.out.println("Employee Found:\n" + emp1);
                    else
                        System.out.println("Employee not found.");
                } 
                else if (sChoice == 2) {
                    System.out.print("Enter Name to search: ");
                    String nm = sc.nextLine();

                    Employee emp2 = dao.searchByName(nm);

                    if (emp2 != null)
                        System.out.println("Employee Found:\n" + emp2);
                    else
                        System.out.println("Employee not found.");
                }
                else {
                    System.out.println("Invalid choice!");
                }

                break;

            case 3:
                System.out.print("Enter ID to update salary: ");
                id = sc.nextInt();
                System.out.print("Enter New Salary: ");
                salary = sc.nextDouble();

                if (dao.updateEmployeeSalary(id, salary))
                    System.out.println("Salary updated successfully!");
                else
                    System.out.println("Employee not found.");
                break;

            case 4:
                System.out.print("Enter ID to remove: ");
                id = sc.nextInt();

                if (dao.removeEmployee(id))
                    System.out.println("Employee removed successfully!");
                else
                    System.out.println("Employee not found.");
                break;

            case 5:
                System.out.println("\n===== All Employees =====");
                dao.displayAllEmployee();
                break;

            case 6:
                System.out.print("Enter Employee ID: ");
                id = sc.nextInt();
                Double salById = dao.getSalaryById(id);
                if (salById != null)
                    System.out.println("Final Salary = " + salById);
                else
                    System.out.println("Employee not found!");
                break;
                
               
            case 7:
                sc.nextLine();
                System.out.print("Enter Employee Name: ");
                String nm = sc.nextLine();
                Double salByName = dao.getSalaryByName(nm);
                if (salByName != null)
                    System.out.println("Final Salary = " + salByName);
                else
                    System.out.println("Employee not found!");
            	break;
            	
            case 8:
                System.out.println("\n===== Salary Report =====");
                dao.printSalaryReport();
                break;

            case 9:
                System.out.println("Total Employees: " + EmployeeDAO.getEmpCount());
                break;
                
            case 10:
                int sortChoice;
                do {
                    System.out.println("\n==== Sorting Menu ====");
                    System.out.println("1. Sort by ID");
                    System.out.println("2. Sort by Name");
                    System.out.println("3. Sort by Salary");
                    System.out.println("4. Back");
                    System.out.print("Enter your choice: ");
                    sortChoice = sc.nextInt();

                    if (sortChoice == 4) {
                        System.out.println("Returning to main menu...");
                        break;
                    }

                    if (sortChoice < 1 || sortChoice > 4) {
                        System.out.println("Invalid choice! Try again.");
                        continue;
                    }

                    System.out.println("Choose Order:");
                    System.out.println("1. ASC");
                    System.out.println("2. DSC");
                    System.out.print("Enter order: ");
                    int orderChoice = sc.nextInt();

                    OrderEnum order;
                    if (orderChoice == 1)
                        order = OrderEnum.ASC;
                    else if (orderChoice == 2)
                        order = OrderEnum.DSC;
                    else {
                        System.out.println("Invalid order! Defaulting to ASC.");
                        order = OrderEnum.ASC;
                    }

                    String attribute = "";
                    switch (sortChoice) {
                        case 1: attribute = "id"; break;
                        case 2: attribute = "name"; break;
                        case 3: attribute = "salary"; break;
                    }

                    dao.sortEmployee(attribute, order);

                    System.out.println("\nEmployees sorted successfully!");
                    dao.displayAllEmployee();

                } while (true);

                break;

                
            case 0:
                System.out.println("Exiting... Goodbye!!");
                break;

            default:
                System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
