package spring.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.entity.Employee;
import spring.service.EmployeeService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {


        @Autowired
        private EmployeeService employeeService;


        @GetMapping("/employees")
        public List<Employee> getCustomers() {


            return employeeService.getEmployees();
        }


        @GetMapping("/employee/employeeid}")
        public Employee getEmployee(@PathVariable int employeeid) {
            Employee employee = null;
            for (int i = 0; i < employeeService.getEmployees().size(); i++) {
                if (employeeService.getEmployees().get(i).getId() == employeeid)
                    employee = employeeService.getEmployees().get(i);
            }
            if (employee == null) {
                throw new CustomerNotFoundException("Employee id not found - " + employeeid);
            }
            return employee;
        }

        @PostMapping("/employees")
        public Employee addEmployee(@RequestBody Employee theEmployee) {
            theEmployee.setId(0);
            employeeService.saveEmployee(theEmployee);
            return theEmployee;
        }

        @PutMapping("/employees")
        public Employee updateEmployee(@RequestBody Employee theEmployee) {
            employeeService.saveEmployee(theEmployee);
            return theEmployee;
        }


        @DeleteMapping("/employees/{employeeid}")
        public String deleteEmployee(@PathVariable int employeeid) {
            Employee employee = null;
            for (int i = 0; i < employeeService.getEmployees().size(); i++) {
                if (employeeService.getEmployees().get(i).getId() == employeeid)
                    employee = employeeService.getEmployees().get(i);
            }
            if (employee == null) {
                throw new CustomerNotFoundException("Employee id not found - " + employeeid);
            }
            employeeService.deleteEmployee(employee.getId());
            return "Delete employee id - " + employeeid;
        }


    }

