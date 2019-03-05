package spring.dao;

import spring.entity.User;

import java.util.List;

public interface UserDAO{

    public List<User> getUser();
    User findByUserName(String userName);

    public void saveUser(User theUser);

    public User getUser(int theId);

    public void deleteUser(int theId);

}
