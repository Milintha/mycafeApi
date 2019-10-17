package com.mycafe.mycafe_api.service.customerService;

import com.mycafe.mycafe_api.model.canteenmodel.Employee;

import java.util.List;


public interface EmployeeService {
    public List<Employee> getAllEmployee();

    public Employee getEmployee(int emp_id);



    public void deleteEmployee(int emp_id);

    public String updateEmployee(int id,Employee employee);

    public  Employee addEmployee(Employee employee);

    public List<Employee> searchEmployee(String name);


}
