import java.util.ArrayList;

class Employee {
    String employeeId, name, role;
    double baseSalary;

    Employee(String id, String n, String r, double sal) {
        employeeId = id;
        name = n;
        role = r;
        baseSalary = sal;
    }

    double calculateSalary() {
        double finalSalary = 0;
        switch (role) {
            case "Manager":
                finalSalary = baseSalary + (baseSalary * 0.20);
                break;
            case "Developer":
                finalSalary = baseSalary + (baseSalary * 0.10); 
                break;
            case "Designer":
                finalSalary = baseSalary + (baseSalary * 0.05); 
                break;
            case "Intern":
                finalSalary = 1000.0; 
                break;
            default:
                finalSalary = baseSalary;
        }
        return finalSalary;
    }

    void displayEmployeeDetails() {
        System.out.println("ID: " + employeeId + " | Name: " + name + " | Role: " + role + " | Final Salary: " + calculateSalary());
    }
}
public class Emp_Payroll {
    public static void main(String[] args) {
        ArrayList<Employee> company = new ArrayList<>();
        company.add(new Employee("101", "Poshak", "Manager", 5000));
        company.add(new Employee("102", "Rahul", "Developer", 4000));
        company.add(new Employee("103", "Thakur", "Intern", 0));

        for (Employee e : company) {
            e.displayEmployeeDetails();
        }
    }
}
