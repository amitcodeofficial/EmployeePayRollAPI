package com.bridgelab.employee.services;

import com.bridgelab.employee.dao.EmployeeRepository;
import com.bridgelab.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceIMPL implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public String addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee Added Successfully";
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public String updateEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee Updated Successfully";
    }

    @Override
    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "Employee Deleted Successfully";
    }
}
