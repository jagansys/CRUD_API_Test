package com.promon.restabi.controller;


import com.promon.restabi.Repository.EmployeeRepository;
import com.promon.restabi.model.EmployeeEntity;
import com.promon.restabi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
public class ApiController {

@Autowired
private EmployeeService employeeService;

    /* @GetMapping("getAllEmployee")
      public List<EmployeeEntity> getAllEmployee() {
          return employeeRepository.findAll();
      } */
   @GetMapping //("getAllEmployee")
    public List<EmployeeEntity> getAllEmployee() {
        return employeeService.getAllEmployeeDetails();
    }

   /* @GetMapping("/{id}")
    @ResponseBody
    public Optional<EmployeeEntity> getEmployee(@PathVariable Integer id) {
       return employeeService.getEmployee(id);
        /*return employeeRepository.findById(id);*/

    @GetMapping("/{id}")
    public ResponseEntity <EmployeeEntity> getEmployeeById(@PathVariable("id") int id ) {
        Optional<EmployeeEntity> employee = employeeService.retriveOne(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public String saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
        Optional<EmployeeEntity> _employee = employeeService.create(employeeEntity);
        if (_employee.isPresent()){
            return "The Employee data has been saved successfully";
        } else {
            return "Employee already exist in records";
        }
    }


    @PutMapping
    public String updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
        Optional<EmployeeEntity> _employee = employeeService.update(employeeEntity);
        if (_employee.isEmpty()){
            return "he Employee data not exist";
        } else {
            return "The Employee data has been updated successfully";
        }
    }


    @DeleteMapping("/{id}")
    public  String deleteEmployeeById(@PathVariable("id") int id) {
        return employeeService.delete(id);
    }
}