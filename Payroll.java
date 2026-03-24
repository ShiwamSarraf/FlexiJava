class Employee {
    
    protected String name;
    protected double baseSalary;

    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double calculateSalary() {
        return baseSalary + (baseSalary * 0.05);
    }
}

class Manager extends Employee {
    Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double calculateSalary() {
        return super.calculateSalary() + 2000;
    }
}

class Executive extends Manager {
    Executive(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double calculateSalary() {
        return super.calculateSalary() + (baseSalary * 0.10);
    }
}

public class Payroll {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", 10000);
        System.out.printf("TC1 Output: %.2f\n", e1.calculateSalary());

        Employee e2 = new Manager("Bob", 10000);
        System.out.printf("TC2 Output: %.2f\n", e2.calculateSalary());

        Employee e3 = new Executive("Charlie", 10000);
        System.out.printf("TC3 Output: %.2f\n", e3.calculateSalary());
    }
}