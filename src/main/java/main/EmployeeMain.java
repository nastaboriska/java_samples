package main;

import domain.employee.Employee;
import java.util.ArrayList;
import java.util.Comparator;

public class EmployeeMain {

  public static void main(String[] args) {
    ArrayList<Employee> employees = getUnsortedEmployeeList();

    //Use-cases of thenComparing
    employees.stream().sorted(Comparator.comparing(Employee::getLastName)).forEach(System.out::println);
    System.out.println("-------");
    employees.stream().sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFirstName).thenComparing(Employee::getAge)).forEach(System.out::println);
  }

  private static ArrayList<Employee> getUnsortedEmployeeList()
  {
    ArrayList<Employee> list = new ArrayList<>();
    list.add( new Employee(2, "Piotr", "Gupta") );
    list.add( new Employee(1, "Alex", "Gupta") );
    list.add( new Employee(4, "Brian", "Beckham") );
    list.add( new Employee(5, "Neon", "Gupta") );
    list.add( new Employee(6, "Neon", "Gupta") );
    list.add( new Employee(3, "David", "Beckham") );
    list.add( new Employee(7, "Andree", "Beckham") );
    list.add( new Employee(8, "Billy", "Gupta") );
    return list;
  }
}
