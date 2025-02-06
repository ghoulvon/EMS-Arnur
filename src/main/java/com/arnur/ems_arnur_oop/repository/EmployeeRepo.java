package com.arnur.ems_arnur_oop.repository;
import com.arnur.ems_arnur_oop.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Query(value = "insert into employees(name,position,salary) values (?,?,?) returning id)", nativeQuery = true)
    Long addEmployee(String name, String position, Double salary);
    @Query(value = "DELETE FROM employees WHERE id = ?", nativeQuery = true)
    void deleteEmployeeById(Long id);

}
