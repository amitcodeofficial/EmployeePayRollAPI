package com.bridgelab.employee.controller;

import com.bridgelab.employee.dto.EmployeeDTO;
import com.bridgelab.employee.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService iEmployeeService;

    @PostMapping("/employee")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        String addMessage = iEmployeeService.addEmployee(employeeDTO);
        return new ResponseEntity<String>(addMessage, HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeDTO>> getEmployee(){
        return new ResponseEntity<List<EmployeeDTO>>(iEmployeeService.getEmployee(), HttpStatus.OK);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<String> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO,@PathVariable int id){
        String updateMessage = iEmployeeService.updateEmployee(employeeDTO,id);
        return new ResponseEntity<String>(updateMessage, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        String deleteMessage = iEmployeeService.deleteEmployee(id);
        return new ResponseEntity<String>(deleteMessage, HttpStatus.OK);
    }
}
