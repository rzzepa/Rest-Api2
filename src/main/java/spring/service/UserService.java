package spring.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import spring.crm.CrmEmployee;
import spring.crm.CrmUser;
import spring.entity.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);

    void save(CrmEmployee crmEmployee);

    public List<User> getUsers();

    public void saveUser(User theUser);

    public User getUser(int theId);

    public void deleteUser(int theId);
}
