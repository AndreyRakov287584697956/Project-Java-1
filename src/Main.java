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
public class Main {
    private static Employee[]employees = new Employee[10];
    public static void printAllEmployees(){
        for(Employee i: employees){
            if (i != null){
                System.out.println("Ф. И. О. - " + i.getName());
                System.out.println("Отдел - " + i.getDepartment());
                System.out.println("Зарплата - " + i.getSalary());
                System.out.println("ИД - " + i.getId());
                System.out.println();
            }
        }
        System.out.println("------------------------------");
    }
    public static void allEmployeesSalary(){
        int sum = 0;
        for (Employee i: employees){
            if(i != null){
                sum += i.getSalary();
            }
        }
        System.out.println("Общая зарплата всех сотрудников - " + sum + " рублей.");
    }
    public static void minSalary(){
        Employee employee = employees[0];
        for (Employee i: employees){
            if (i != null && employee.getSalary() > i.getSalary()){
                employee = i;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой - " + employee.getName());
    }
    public static void maxSalary(){
        Employee employee = employees[0];
        for (Employee i: employees){
            if (i != null && employee.getSalary() < i.getSalary()){
                employee = i;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой - " + employee.getName());
    }
    public static void allEmployeesAvgSalary(){
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
    public static void salaryIndex(double a){
        for (Employee i: employees){
            if (i != null){
                i.setSalary((int)(i.getSalary() * (100 + a) / 100));
            }
        }
        printAllEmployees();
    }
    public static void minSalaryDepartment(int a){
        Employee employee = employees[0];
        for (Employee i: employees){
            if (i != null && employee.getSalary() > i.getSalary() && i.getDepartment() == a){
                employee = i;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой по отделу " + a + "  - " + employee.getName());
    }
    public static void maxSalaryDepartment(int a){
        Employee employee = employees[0];
        for (Employee i: employees){
            if (i != null && employee.getSalary() < i.getSalary() && i.getDepartment() == a){
                employee = i;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой по отделу " + a + " - " + employee.getName());
    }
    public static void allEmployeesSalaryDepartment(int a){
        int sum = 0;
        for (Employee i: employees){
            if(i != null && i.getDepartment() == a){
                sum += i.getSalary();
            }
        }
        System.out.println("Общая зарплата всех сотрудников по отделу " + a + " - " + sum + " рублей.");
    }
    public static void allEmployeesAvgSalaryDepartment(int a){
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
    public static void printAllEmployeesDepartment(int a){
        for(Employee i: employees){
            if (i != null && i.getDepartment() == a){
                System.out.println("Ф. И. О. - " + i.getName());
                System.out.println("Зарплата - " + i.getSalary());
                System.out.println("ИД - " + i.getId());
                System.out.println();
            }
        }
        System.out.println("------------------------------");
    }
    public static void salaryIndexDepartment(double a, int b){
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
    public static void printEmployeesLessThanSalary(int a){
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
    public static void printEmployeesMoreThanSalary(int a){
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
    public static void main(String[] args) {
    employees[0] = new Employee("Иванов Иван Иванович", 1, 50000);
    employees[1] = new Employee("Петров Алексей Васильевич", 2, 70000);
    employees[2] = new Employee("Уткин Александр Игоревич", 2, 40000);
    printAllEmployees();
    allEmployeesSalary();
    minSalary();
    maxSalary();
    allEmployeesAvgSalary();
    salaryIndex(0);
    minSalaryDepartment(2);
    maxSalaryDepartment(2);
    allEmployeesSalaryDepartment(2);
    allEmployeesAvgSalaryDepartment(2);
    salaryIndexDepartment(0, 2);
    printAllEmployeesDepartment(2);
    printEmployeesLessThanSalary(30000);
    printEmployeesMoreThanSalary(50000);
    }
}