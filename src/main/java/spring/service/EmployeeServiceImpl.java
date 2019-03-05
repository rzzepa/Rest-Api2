package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.EmployeeDAO;
import spring.entity.Customer;
import spring.entity.Employee;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeedao;

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeedao.getEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee theEmployee) {
        employeedao.saveEmployee(theEmployee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int theId) {
        return employeedao.getEmployee(theId);
    }

    @Override
    @Transactional
    public void deleteEmployee(int theId) {
        employeedao.deleteEmployee(theId);
    }
}
