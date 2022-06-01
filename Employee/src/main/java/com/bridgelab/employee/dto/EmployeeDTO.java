package com.bridgelab.employee.dto;

import com.bridgelab.employee.model.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    @NotEmpty
    @Size(min = 4,message = "Employee Name should be 4 characters minimum")
    private String name;
    @NotEmpty
    @Size(min = 4,message = "Employee Gender Should Not be Null")
    private String gender;
    @NotEmpty(message = "Employee Department Should not be Null")
    public List<Department> department;
    @NotNull
    @Min(value = 1,message = "Employee Salary Should not be Null")
    private int salary;
    @NotNull
    @Min(value = 1,message = "Employee Start Day Should not be Null")
    private int startDay;
    @NotNull
    @Min(value = 1,message = "Employee Start Month Should not be Null")
    private int startMonth;
    @NotNull
    @Min(value = 1,message = "Employee Start Year Should not be Null")
    private int startYear;
}
