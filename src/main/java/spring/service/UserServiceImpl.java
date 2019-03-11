package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.crm.CrmEmployee;
import spring.crm.CrmUser;
import spring.dao.AuthorityDAO;
import spring.dao.CustomerDAO;
import spring.dao.EmployeeDAO;
import spring.dao.UserDAO;
import spring.entity.Authority;
import spring.entity.Customer;
import spring.entity.Employee;
import spring.entity.User;

import java.util.HashSet;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userdao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityDAO authorityDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public User findByUserName(String userName) {
        // check the database if the user already exists
        return userdao.findByUserName(userName);
    }



    @Override
    @Transactional
    public void save(CrmUser crmUser) {
        User user = new User();
        // assign user details to the user object
        user.setUsername(crmUser.getUserName());
        user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
        user.setEnabled(1);

        Customer customer = new Customer();

        customer.setEmail(crmUser.getEmail());
        customer.setFirstName(crmUser.getFirstName());
        customer.setLastName(crmUser.getLastName());
        customer.setAdress(crmUser.getAdress());

        customer.setUser(user);

        // give user default role of "employee"
        HashSet<Authority> authorities = new HashSet<>();
        Authority newOne = new Authority("ROLE_CUSTOMER",crmUser.getUserName());
        authorities.add(newOne);
        user.setAuthorities(authorities);

        // save user in the database
        customerDAO.saveCustomer(customer);
        authorityDAO.saveAuthority(newOne);
        userdao.saveUser(user);
    }


    @Override
    @Transactional
    public void save(CrmEmployee crmEmployee) {
        User user = new User();
        // assign user details to the user object
        user.setUsername(crmEmployee.getUserName());
        user.setPassword(passwordEncoder.encode(crmEmployee.getPassword()));
        user.setEnabled(1);

        Employee employee= new Employee();

        employee.setEmail(crmEmployee.getEmail());
        employee.setFirstname(crmEmployee.getFirstName());
        employee.setLastname(crmEmployee.getLastName());
        employee.setAdress(crmEmployee.getAdress());
        employee.setSalary(crmEmployee.getSalary());

        employee.setUser(user);

        // give user default role of "employee"
        HashSet<Authority> authorities = new HashSet<>();
        Authority newOne = new Authority(crmEmployee.getRole(), crmEmployee.getUserName());
        authorities.add(newOne);
        user.setAuthorities(authorities);

        // save user in the database
        employeeDAO.saveEmployee(employee);
        authorityDAO.saveAuthority(newOne);
        userdao.saveUser(user);
    }


    @Override
    @Transactional
    public List<User> getUsers() {
        return userdao.getUser();
    }

    @Override
    @Transactional
    public void saveUser(User theUser) {
        userdao.saveUser(theUser);
    }

    @Override
    @Transactional
    public User getUser(int theId) {
        return userdao.getUser(theId);
    }

    @Override
    @Transactional
    public void deleteUser(int theId) {
        userdao.deleteUser(theId);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
