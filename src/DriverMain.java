import java.util.Scanner;
interface Taxable {
    double sales_tax = 0.07;//initializing variables
    double income_tax = 0.105;

    double calcTax();
}
 class Employee implements Taxable //implementation
 {
    private int empId;
    private String name;
    private double salary;

    public Employee(int empId, String name, double salary)//parameterized constructor
    {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double calcTax()
    {
        return salary * income_tax;//calculate income Tax on yearly salary.
    }
    public void display()
    {
        System.out.println("empId:"+empId);
        System.out.println("name:"+name);
        System.out.println("salary:"+salary);
    }
}
 class Product implements Taxable {
    private int pid;
    private double price;
    private int quantity;

    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public double calcTax() {
        return price * sales_tax;//calculate sales Tax on unit price of product.
    }
    public void display()
    {
        System.out.println("pid:"+pid);
        System.out.println("price:"+price);
        System.out.println("quantity:"+quantity);
    }
 }


public class DriverMain//create a main class
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);//using sacnner.

        // Accept employee information
        System.out.println("Enter Employee ID: ");
        int empId = scanner.nextInt();
        System.out.println("Enter Employee Name: ");
        scanner.nextLine();  // Consume newline
        String name = scanner.nextLine();
        System.out.println("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(empId, name, salary);
        double incomeTax = employee.calcTax();
        employee.display();
        System.out.println("Income Tax for "+ incomeTax);

        // Accept product information
        System.out.println("Enter Product ID: ");
        int pid = scanner.nextInt();
        System.out.println("Enter Product Price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter Product Quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(pid, price, quantity);
        double salesTax = product.calcTax();
        product.display();
        System.out.println("Sales Tax for Product ID "+salesTax);

        scanner.close();
    }
}