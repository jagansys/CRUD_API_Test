package com.promon.restabi.service;

import com.promon.restabi.Repository.EmployeeRepository;
import com.promon.restabi.model.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    /*public Optional<EmployeeEntity> getEmployee(int id) {
        return employeeRepository.findById(id);
    }*/

public  Optional<EmployeeEntity> retriveOne(int id) {
        return employeeRepository.findById(id);
}

public List<EmployeeEntity> getAllEmployeeDetails(){
    return employeeRepository.findAll();
}
public Optional<EmployeeEntity> create(EmployeeEntity employeeEntity) {
    if (employeeRepository.existsById(employeeEntity.getEmployee_id())){
        return Optional.empty();
    }else {
        return Optional.of(employeeRepository.save(employeeEntity));
    }
}

public Optional<EmployeeEntity> update(EmployeeEntity employeeEntity) {
    if (employeeRepository.existsById(employeeEntity.getEmployee_id())){
        return Optional.of(employeeRepository.save(employeeEntity));
    } else {
        return Optional.empty();
    }
}

public String delete (int empid){
    if (employeeRepository.existsById(empid)){
        employeeRepository.deleteById(empid);
        return empid + "deleted successfully";
    } else {
        return "The employee data not exist ";
    }
}

}
