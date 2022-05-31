package com.bridgelab.employee.controller;

import com.bridgelab.employee.model.Employee;
import com.bridgelab.employee.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService iEmployeeService;

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        String addMessage = iEmployeeService.addEmployee(employee);
        return new ResponseEntity<String>(addMessage, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getEmployee(){
        return new ResponseEntity<List<Employee>>(iEmployeeService.getEmployee(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
        String updateMessage = iEmployeeService.updateEmployee(employee);
        return new ResponseEntity<String>(updateMessage, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        String deleteMessage = iEmployeeService.deleteEmployee(id);
        return new ResponseEntity<String>(deleteMessage, HttpStatus.OK);
    }
}
