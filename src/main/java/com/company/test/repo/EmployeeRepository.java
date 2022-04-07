package com.company.test.repo;

import com.company.test.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("select e from Employee e " +
                    "where concat" +
                    "(e.fullName, e.dept, e.email," +
                    " e.speciality, e.structure, e.employeeNumber) like %?1%")
//  @Query("select e from Employee e where concat  (upper(e.fullName), upper(e.dept), upper(e.email), upper(e.speciality), upper(e.structure), e.employeeNumber) like upper('%?1%')")
    List<Employee> search(String keyword);

}