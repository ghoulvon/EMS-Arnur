package com.arnur.ems_arnur_oop.api.model;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employees")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AllArgsConstructor //constructor with arguments
@NoArgsConstructor //empty constructor
@DiscriminatorColumn (name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Employee")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type",defaultImpl = Employee.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Manager.class, name = "Manager"),
        @JsonSubTypes.Type(value = Intern.class, name = "Intern")
})
public  class Employee {
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