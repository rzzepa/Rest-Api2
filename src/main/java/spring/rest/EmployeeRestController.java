package spring.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.entity.Employee;
import spring.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {


        @Autowired
        private EmployeeService employeeService;


        @GetMapping("/employees")
        public String getCustomers() {
            List<Employee> employees = employeeService.getEmployees();
            String str = "<head><style>" +
                    "table {border-collapse: collapse;width: 100%;}" +
                    "th, td {text-align: left padding: 8px; } " +
                    "tr:nth-child(even){background-color: #f2f2f2}" +
                    "th {background-color: #5988f7;  color: white}" +
                    "</style></head><body><table border-bottom: 1px solid #ddd><tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Adress</th><th>User</th><th>Salary</th>";
            for (int i = 0; i < employees.size(); i++) {
                str += "<tr>";
                str += "<td>" + employees.get(i).getId() + "</td>";
                str += "<td>" + employees.get(i).getFirstname() + "</td>";
                str += "<td>" + employees.get(i).getLastname() + "</td>";
                str += "<td>" + employees.get(i).getAdress() + "</td>";
                str += "<td>" + employees.get(i).getUser().getUsername() + "</td>";
                str += "<td>" + employees.get(i).getSalary() + "</td>";
            }
            str += "</body>";

            return str;
        }


        @GetMapping("/employee/employeeid}")
        public String getEmployee(@PathVariable int employeeid) {
            List<Employee> lista = employeeService.getEmployees();
            String str = "<head><style>" +
                    "table {border-collapse: collapse;width: 100%;}" +
                    //"th, td {text-align: left padding: 8px; } " +
                    "tr:nth-child(even){background-color: #f2f2f2}" +
                    "th {background-color: #5988f7;  color: white}" +
                    //"td {text-align:center;}"+
                    "</style></head><body><table border-bottom: 1px solid #ddd><tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Adress</th><th>User</th><th>Salary</th>";
            for (int i = 0; i < employeeService.getEmployees().size(); i++) {
                if (lista.get(i).getId() == employeeid) {
                    str += "<tr>";
                    str += "<td><center>" + lista.get(i).getId() + "</center></td>";
                    str += "<td>" + lista.get(i).getFirstname() + "</td>";
                    str += "<td>" + lista.get(i).getLastname() + "</td>";
                    str += "<td>" + lista.get(i).getAdress() + "</td>";
                    str += "<td>" + lista.get(i).getUser().getUsername() + "</td>";
                    str += "<td>" + lista.get(i).getSalary() + "</td>";
                }
            }

            str += "</body>";

            return str;
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

