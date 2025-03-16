package com.arnur.ems_arnur_oop.api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("Intern")
public class Intern extends Employee {
    private String university;

    public Intern(Long id, String name, String position, double salary, String university) {
        super(id, name, position,salary);
        this.university = university;
    }

    @Override
    public void work() {
        System.out.println(getName() + " is interning from " + university);
    }
}