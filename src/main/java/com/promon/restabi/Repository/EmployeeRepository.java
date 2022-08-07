package com.promon.restabi.Repository;

import com.promon.restabi.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <EmployeeEntity, Integer> {
}
