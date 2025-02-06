package com.arnur.ems_arnur_oop.api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Manager")
@Data
@NoArgsConstructor
public class Manager extends Employee {
    private String department;

    public Manager(Long id, String name, String position, double salary, String department) {
        super(id, name, position, salary);
        this.department = department;
    }
    @Override
    public void work() {
        System.out.println(getName() + " is managing the " + department + " team.");
    }
}
