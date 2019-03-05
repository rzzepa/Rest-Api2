package spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getEmployees() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Employee> theQuery =
                currentSession.createQuery("from Employee",
                        Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public void saveEmployee(Employee theEmployee) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theEmployee);
    }

    @Override
    public Employee getEmployee(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Employee theEmployee = currentSession.get(Employee.class, theId);

        return theEmployee;
    }

    @Override
    public void deleteEmployee(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery =
                currentSession.createQuery("delete from Employee where id=:id");
        theQuery.setParameter("id", theId);
        theQuery.executeUpdate();
    }
}
