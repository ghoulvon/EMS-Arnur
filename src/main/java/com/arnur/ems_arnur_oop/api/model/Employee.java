package com.arnur.ems_arnur_oop.api.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employees")
@Data
@DiscriminatorColumn (name = "type", discriminatorType = DiscriminatorType.STRING)
@AllArgsConstructor //constructor with arguments
@NoArgsConstructor //empty constructor
@DiscriminatorValue("Simple Employee")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    private double salary;
    public void work() {
        System.out.println(getName() + " is working as " + getPosition());
    }
}