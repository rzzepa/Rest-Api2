package spring.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.entity.User;
import org.hibernate.SessionFactory;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByUserName(String theUserName) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using username
        Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
        theQuery.setParameter("uName", theUserName);
        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }

    @Override
    public List<User> getUser() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<User> theQuery =
                currentSession.createQuery("from User order by id",
                        User.class);
        List<User> users = theQuery.getResultList();

        // return the results
        return users;
    }

    @Override
    public void saveUser(User theUser) {
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the customer ... finally LOL
        currentSession.saveOrUpdate(theUser);
    }

    @Override
    public User getUser(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        User theUser = currentSession.get(User.class, theId);

        return theUser;
    }

    @Override
    public void deleteUser(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from User where id=:id");
        theQuery.setParameter("id", theId);

        theQuery.executeUpdate();
    }
}
