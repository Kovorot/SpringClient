package ru.kovorot.spring.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kovorot.spring.client.configuration.Config;
import ru.kovorot.spring.client.entity.Employee;

import java.util.List;

public class App {

    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Communication communication = context.getBean("communication", Communication.class);

        List<Employee> allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);

        Employee employee = communication.getEmployee(1);
        System.out.println(employee);

        Employee emp = new Employee();
        emp.setName("Sveta");
        emp.setSurname("Sokolova");
        emp.setDepartment("IT");
        emp.setSalary(1200);
        emp.setId(10);
        communication.saveEmployee(emp);

        communication.deleteEmployee(10);
    }
}
