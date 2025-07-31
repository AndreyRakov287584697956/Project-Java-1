import java.util.Objects;
import java.util.Scanner;

class Employee{
    private static int count = 0;
    private String name;
    private int department;
    private int salary;
    private final int id;
    public String getName(){
        return name;
    }
    public int getDepartment(){
        return department;
    }
    public void setDepartment(int a){
        department = a;
    }
    public int getSalary(){
        return salary;
    }
    public void setSalary(int a){
        salary = a;
    }
    public int getId(){
        return id;
    }
    public Employee(String name, int department, int salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.id = count++;
    }
}
class EmployeeBook{
    private int employeeCount;
    private Employee[]employees;
    private Scanner scanner = new Scanner(System.in);
    public EmployeeBook(int employeeCount){
        this.employees = new Employee[employeeCount];
        employeeCount = 0;
    }
    public void printAllEmployees(){
        for(Employee i: employees){
            if (i != null){
                System.out.println("------------------------------");
                System.out.println("Ф. И. О. - " + i.getName());
                System.out.println("Отдел - " + i.getDepartment());
                System.out.println("Зарплата - " + i.getSalary());
                System.out.println("ИД - " + i.getId());
                System.out.println();
            }
        }
        System.out.println("------------------------------");
    }
    public void allEmployeesSalary(){
        int sum = 0;
        for (Employee i: employees){
            if(i != null){
                sum += i.getSalary();
            }
        }
        System.out.println("Общая зарплата всех сотрудников - " + sum + " рублей.");
    }
    public void minSalary(){
        Employee employee = employees[0];
        for (Employee i: employees){
            if (i != null){
                employee = i;
                break;
            }
        }
        for (Employee i: employees){
            if (i != null && employee.getSalary() > i.getSalary()){
                employee = i;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой - " + employee.getName());
    }
    public void maxSalary(){
        Employee employee = employees[0];
        for (Employee i: employees){
            if (i != null){
                employee = i;
                break;
            }
        }
        for (Employee i: employees){
            if (i != null && employee.getSalary() < i.getSalary()){
                employee = i;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой - " + employee.getName());
    }
    public void allEmployeesAvgSalary(){
        int sum = 0;
        int currentEmployees = 0;
        for (Employee i: employees){
            if(i != null){
                sum += i.getSalary();
                currentEmployees ++;
            }
        }
        System.out.println("Средняя зарплата - " + sum / currentEmployees + " рублей.");
    }
    public void salaryIndex(double a){
        for (Employee i: employees){
            if (i != null){
                i.setSalary((int)(i.getSalary() * (100 + a) / 100));
            }
        }
        printAllEmployees();
    }
    public void minSalaryDepartment(int a){
        Employee employee = employees[0];
        for (Employee i: employees){
            if (i != null){
                employee = i;
                break;
            }
        }
        for (Employee i: employees){
            if (i != null && employee.getSalary() > i.getSalary() && i.getDepartment() == a){
                employee = i;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой по отделу " + a + "  - " + employee.getName());
    }
    public void maxSalaryDepartment(int a){
        Employee employee = employees[0];
        for (Employee i: employees){
            if (i != null){
                employee = i;
                break;
            }
        }
        for (Employee i: employees){
            if (i != null && employee.getSalary() < i.getSalary() && i.getDepartment() == a){
                employee = i;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой по отделу " + a + " - " + employee.getName());
    }
    public void allEmployeesSalaryDepartment(int a){
        int sum = 0;
        for (Employee i: employees){
            if(i != null && i.getDepartment() == a){
                sum += i.getSalary();
            }
        }
        System.out.println("Общая зарплата всех сотрудников по отделу " + a + " - " + sum + " рублей.");
    }
    public void allEmployeesAvgSalaryDepartment(int a){
        int sum = 0;
        int currentEmployees = 0;
        for (Employee i: employees){
            if(i != null && i.getDepartment() == a){
                sum += i.getSalary();
                currentEmployees ++;
            }
        }
        System.out.println("Средняя зарплата по отделу " + a + " - " + sum / currentEmployees + " рублей.");
    }
    public void printAllEmployeesDepartment(int a){
        for(Employee i: employees){
            if (i != null && i.getDepartment() == a){
                System.out.println("------------------------------");
                System.out.println("Ф. И. О. - " + i.getName());
                System.out.println("Зарплата - " + i.getSalary());
                System.out.println("ИД - " + i.getId());
                System.out.println();
            }
        }
        System.out.println("------------------------------");
    }
    public void salaryIndexDepartment(double a, int b){
        for (Employee i: employees){
            if (i != null && i.getDepartment() == b){
                i.setSalary((int)(i.getSalary() * (100 + a) / 100));
            }
        }
        System.out.println();
        System.out.println("Сотрудники с проиндексированной зарплатой");
        printAllEmployeesDepartment(b);
        System.out.println();
    }
    public void printEmployeesLessThanSalary(int a){
        for(Employee i: employees){
            if (i != null && i.getSalary() < a){
                System.out.println("Ф. И. О. - " + i.getName());
                System.out.println("Зарплата - " + i.getSalary());
                System.out.println("ИД - " + i.getId());
                System.out.println();
            }
        }
        System.out.println("------------------------------");
    }
    public void printEmployeesMoreThanSalary(int a){
        for(Employee i: employees){
            if (i != null && i.getSalary() > a){
                System.out.println("Ф. И. О. - " + i.getName());
                System.out.println("Зарплата - " + i.getSalary());
                System.out.println("ИД - " + i.getId());
                System.out.println();
            }
        }
        System.out.println("------------------------------");
    }
    public void addEmployee(String name, int department, int salary){
        if (employeeCount >= employees.length){
            System.out.println("Больше нельзя добавить сотрудников. Штат переполнен");
            return;
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null){
                employees[i] = new Employee(name, department, salary);
                System.out.println("Сотрудник добавлен!");
                return;
            }
        }
    }
    public void deleteEmployee(String name){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && Objects.equals(name, employees[i].getName())){
                employees[i] = null;
                System.out.println("Сотрудник уволен!");
                return;
            }
        }
    }
    public void deleteEmployee(int id){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && id == employees[i].getId()){
                employees[i] = null;
                System.out.println("Сотрудник уволен!");
                return;
            }
        }
    }
    public void editEmployeeSalary(String name){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && Objects.equals(name, employees[i].getName())){
                System.out.println("Изменение данных сотрудника - " + name + ".");
                System.out.print("Введите новую зарплату: ");
                int inputSalary = scanner.nextInt();
                employees[i].setSalary(inputSalary);
                System.out.println("Успешно изменена зарплата!");
                return;
            }
        }
    }
    public void editEmployeeDepartment(String name){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && Objects.equals(name, employees[i].getName())){
                System.out.println("Изменение данных сотрудника - " + name + ".");
                System.out.print("Введите новый отдел: ");
                int inputDepartment = scanner.nextInt();
                if (inputDepartment < 6){
                    employees[i].setDepartment(inputDepartment);
                }
                System.out.println("Успешно изменён отдел!");
                return;
            }
        }
    }
    public void printEmployeesDepartment(){
        for (int i = 1; i < 6; i ++){
            System.out.println("Отдел " + i + ":");
            for (Employee j: employees){
                if (j != null && j.getDepartment() == i){
                    System.out.println("Ф. И. О. - " + j.getName());
                }
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
    EmployeeBook employeeBook = new EmployeeBook(10);
//    employeeBook.employees[0] = new Employee("Иванов Иван Иванович", 1, 50000);
//    employees[1] = new Employee("Петров Алексей Васильевич", 2, 70000);
//    employees[2] = new Employee("Уткин Александр Игоревич", 2, 40000);
    employeeBook.addEmployee("Петров Алексей Васильевич", 2, 70000);
    employeeBook.addEmployee("Иванов Иван Иванович", 1, 50000);
    employeeBook.addEmployee("Уткин Александр Игоревич", 2, 80000);
    employeeBook.printEmployeesDepartment();
    employeeBook.deleteEmployee("Иванов Иван Иванович");
    employeeBook.deleteEmployee(0);
    employeeBook.printAllEmployees();
    employeeBook.allEmployeesSalary();
    employeeBook.minSalary();
    employeeBook.maxSalary();
    employeeBook.allEmployeesAvgSalary();
    employeeBook.salaryIndex(0);
    employeeBook.minSalaryDepartment(2);
    employeeBook.maxSalaryDepartment(2);
    employeeBook.allEmployeesSalaryDepartment(2);
    employeeBook.allEmployeesAvgSalaryDepartment(2);
    employeeBook.salaryIndexDepartment(0, 2);
    employeeBook.printAllEmployeesDepartment(2);
    employeeBook.printEmployeesLessThanSalary(30000);
    employeeBook.printEmployeesMoreThanSalary(50000);
    employeeBook.editEmployeeSalary("Уткин Александр Игоревич");
    employeeBook.editEmployeeDepartment("Уткин Александр Игоревич");
    employeeBook.printAllEmployees();
    }
}