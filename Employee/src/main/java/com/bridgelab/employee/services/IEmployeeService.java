package com.bridgelab.employee.services;

import com.bridgelab.employee.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public String addEmployee(Employee employee);
    public List<Employee> getEmployee();
    public String updateEmployee(Employee employee);
    public String deleteEmployee(int id);
}
