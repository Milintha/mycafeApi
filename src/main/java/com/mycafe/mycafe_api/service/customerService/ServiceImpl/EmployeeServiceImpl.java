package com.mycafe.mycafe_api.service.customerService.ServiceImpl;

import com.mycafe.mycafe_api.model.canteenmodel.Employee;
import com.mycafe.mycafe_api.repository.customerRepository.EmployeeRepository;
import com.mycafe.mycafe_api.service.customerService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int emp_id) {
        Employee emp= employeeRepository.findById(emp_id).get();

        if(emp!=null){
            return emp;
        }
        return null;
    }

    @Override
    public void deleteEmployee(int emp_id)
    {

        if(employeeRepository.findById(emp_id).get()!=null){
            employeeRepository.deleteById(emp_id);
        }

    }

    @Override
    public String updateEmployee(int id,Employee employee) {

        if(employeeRepository.findById(id).get()!=null){
            Employee emp=employeeRepository.save(employee);
            if(emp!= null){
                return "Update Succesfull";

            }

            return "Upadate Failed";
        }
        return "Invalid ID";
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }

    @Override
    public List<Employee> searchEmployee(String name) {
        return employeeRepository.finfByName(name);
    }
}


