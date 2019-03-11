package spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.entity.Customer;

import java.io.PrintWriter;
import java.util.List;
import spring.service.CustomerService;


@RestController
@RequestMapping("/api")
public class CustomerRestController {


    @Autowired
    private CustomerService Customerservice;


    @GetMapping("/customers")
    public String getCustomers(Model theModel) {


        List<Customer> customers = Customerservice.getCustomers();
        theModel.addAttribute("customers", customers);

        String str = "<head><style>" +
                "table {border-collapse: collapse;width: 100%;}" +
                "th, td {text-align: left padding: 8px; }" +
                "tr:nth-child(even){background-color: #f2f2f2}" +
                "th {background-color: #4CAF50;  color: white}" +
                "</style></head><body><table><tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Adress</th><th>User</th>";
        for (int i = 0; i < customers.size(); i++) {
            str += "<tr>";
            str += "<td>" + customers.get(i).getId() + "</td>";
            str += "<td>" + customers.get(i).getFirstName() + "</td>";
            str += "<td>" + customers.get(i).getLastName() + "</td>";
            str += "<td>" + customers.get(i).getAdress() + "</td>";
            str += "<td>" + customers.get(i).getUser().getUsername() + "</td>";
        }
        str += "</body>";
        // return str;
        return "customer-service.jsp";
    }



    @GetMapping("/customers/{customerid}")
    public Customer getCustomer(@PathVariable int customerid) {
        Customer customer=null;
        for (int i = 0; i < Customerservice.getCustomers().size(); i++) {
            if(Customerservice.getCustomers().get(i).getId()==customerid) customer=Customerservice.getCustomers().get(i);
        }
        if(customer==null)
        {
            throw new CustomerNotFoundException("Customer id not found - " + customerid);
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer)
    {
        theCustomer.setId(0);
        Customerservice.saveCustomer(theCustomer);
        return theCustomer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer)
    {
        Customerservice.saveCustomer(theCustomer);
        return theCustomer;
    }


    @DeleteMapping("/customers/{customerid}")
    public String deleteCustomer(@PathVariable int customerid)
    {
        Customer customer=null;
        for (int i = 0; i < Customerservice.getCustomers().size(); i++) {
            if(Customerservice.getCustomers().get(i).getId()==customerid) customer=Customerservice.getCustomers().get(i);
        }
        if(customer==null)
        {
            throw new CustomerNotFoundException("Customer id not found - " + customerid);
        }
        Customerservice.deleteCustomer(customer.getId());
        return "Delete customer id - "+customerid;
    }


}
