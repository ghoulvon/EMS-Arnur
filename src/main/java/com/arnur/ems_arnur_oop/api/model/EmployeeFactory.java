package com.arnur.ems_arnur_oop.api.model;

public class EmployeeFactory {
    public static Employee createEmployee(String type, Long id, String name, String position, double salary, String extraInfo) {
        if ("Manager".equalsIgnoreCase(type)) {
            return new Manager(id, name, position, salary, extraInfo);  // extraInfo в данном случае будет департаментом
        } else if ("Intern".equalsIgnoreCase(type)) {
            return new Intern(id, name, position, salary, extraInfo);  // extraInfo будет университетом
        } else {
            return new Employee(id, name, position, salary);
        }
    }

}
