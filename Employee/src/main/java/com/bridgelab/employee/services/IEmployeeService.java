package com.bridgelab.employee.services;

import com.bridgelab.employee.dto.EmployeeDTO;
import com.bridgelab.employee.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public String addEmployee(EmployeeDTO employeeDTO);
    public List<EmployeeDTO> getEmployee();
    public String updateEmployee(EmployeeDTO employeeDTO, int id);
    public String deleteEmployee(int id);
}
