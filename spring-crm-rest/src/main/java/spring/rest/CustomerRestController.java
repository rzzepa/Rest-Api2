package spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.entity.Customer;
import spring.service.CustomerService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {


    @Autowired
    private CustomerService Customerservice;


    @GetMapping("/customers")
    public List<Customer> getCustomers() {


        return Customerservice.getCustomers();
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
