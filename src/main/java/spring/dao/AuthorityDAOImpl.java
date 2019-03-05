package spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.entity.Authority;
import spring.entity.Customer;

import java.util.List;

@Repository
public class AuthorityDAOImpl implements AuthorityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Authority> getAuthority() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Authority> theQuery =
                currentSession.createQuery("from Authority order by id",
                        Authority.class);
        List<Authority> authorities = theQuery.getResultList();

        // return the results
        return authorities;

    }


    @Override
    public void saveAuthority(Authority theAuthority) {

        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the customer ... finally LOL
        currentSession.saveOrUpdate(theAuthority);
    }

    @Override
    public Authority getAuthority(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Authority theAuthority = currentSession.get(Authority.class, theId);

        return theAuthority;
    }

    @Override
    public void deleteAuthority(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Authority where id=:theId");
        theQuery.setParameter("id", theId);

        theQuery.executeUpdate();

    }


}
