package com.bridgelab.employee.services;

import com.bridgelab.employee.dao.EmployeeRepository;
import com.bridgelab.employee.dto.EmployeeDTO;
import com.bridgelab.employee.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class EmployeeServiceIMPL implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employeeRepository.save(employee);
        return "Employee Added Successfully";
    }

    @Override
    public List<EmployeeDTO> getEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<EmployeeDTO>();
        ListIterator list = employeeList.listIterator();
        while(list.hasNext()){
            Employee tempEmployee = (Employee) list.next();
            EmployeeDTO tempEmployeeDTO = employeeToDto(tempEmployee);
            employeeDTOList.add(tempEmployeeDTO);
        }
        return employeeDTOList;
    }

    @Override
    public String updateEmployee(EmployeeDTO employeeDTO, int id) {
        Employee employee = employeeRepository.findById(id).get();
        if(employee!=null){
            Employee tempEmployee = dtoToEmployee(employeeDTO,employee);
            employeeRepository.save(tempEmployee);
            return "Employee Updated Successfully";
        }else{
            return "Wrong Id";
        }
    }

    @Override
    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "Employee Deleted Successfully";
    }

    public Employee dtoToEmployee(EmployeeDTO employeeDTO, Employee employee){
        modelMapper.map(employeeDTO, employee);
        return employee;
    }

    public EmployeeDTO employeeToDto(Employee employee){
        EmployeeDTO employeeDTO = modelMapper.map(employee,EmployeeDTO.class);
        return employeeDTO;
    }
}
