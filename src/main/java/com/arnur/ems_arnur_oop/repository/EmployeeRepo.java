package com.arnur.ems_arnur_oop.repository;
import com.arnur.ems_arnur_oop.api.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Modifying
    @Transactional
    @Query(
        value = "INSERT INTO employees (name, position, salary, type) VALUES (?1, ?2, ?3) RETURNING id",
        nativeQuery = true
    )
    Long addEmployee(String name, String position, Double salary);
    @Query(value = "DELETE FROM employees WHERE id = :id", nativeQuery = true)
    void deleteById(@Param("id") Long id);

}
